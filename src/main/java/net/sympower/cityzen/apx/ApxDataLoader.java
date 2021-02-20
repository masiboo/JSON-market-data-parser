package net.sympower.cityzen.apx;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sympower.cityzen.apx.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ApxDataLoader {

    @Value("${apxDataLoader.url}")
    String urlStr;

    URL url;

    public void init() throws MalformedURLException {
        if (this.url == null) {
            this.url = new URL(urlStr);
        }
    }

    public QuoteResponse load() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Wrapper wrapper = mapper.readValue(url, Wrapper.class);
        return getResponse(wrapper);
    }

    public QuoteResponse getResponse(Wrapper wrapper) {
        QuoteResponse toReturn = new QuoteResponse();
        Quote quote = new Quote();
        toReturn.getQuotes().add(quote);

        for (QuoteRaw quoteRaw : wrapper.getQuotes()) {

            quote.setDate(quoteRaw.getDateApplied());

            QuoteValue quoteValue = new QuoteValue();
            quote.getQuoteValueByHour().add(quoteValue);

            for (QuoteValueRaw quoteValueRaw : quoteRaw.getQuoteValues()) {

                switch (quoteValueRaw.getTLabel()) {
                    case "Order":
                        quoteValue.setHour(Integer.parseInt(quoteValueRaw.getValue()));
                        break;
                    case "Net Volume":
                        quoteValue.setNetVolume(Double.parseDouble(quoteValueRaw.getValue()));
                        break;
                    case "Price":
                        quoteValue.setPrice(Double.parseDouble(quoteValueRaw.getValue()));
                        break;
                }
            }
        }
        return toReturn;
    }
}
