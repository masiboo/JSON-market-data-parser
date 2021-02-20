package net.sympower.cityzen.apx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import net.sympower.cityzen.apx.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Getter
@Setter
@Service
public class ApxDataLoader {

    private static final String ORDER = "Order";
    private static final String NET_VOLUME  = "Net Volume";
    private static final String PRICE = "Price";

    @Value("${apxDataLoader.url}")
    private String urlStr;

    private URL url;

    public void init() throws MalformedURLException {
        if (this.url == null) {
            this.url = new URL(urlStr);
        }
    }

    public QuoteResponse load() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Wrapper wrapper = mapper.readValue(url, Wrapper.class);
        // pretty print json
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(wrapper);
        System.out.println(json);

        return getResponse(wrapper);
    }

    public QuoteResponse getResponse(Wrapper wrapper) {
        QuoteResponse returnQuoteResponse = new QuoteResponse();
        Quote quote = new Quote();
        returnQuoteResponse.getQuotes().add(quote);

        for (QuoteRaw quoteRaw : wrapper.getQuotes()) {
            quote.setDate(quoteRaw.getDateApplied());
            QuoteValue quoteValue = new QuoteValue();
            quote.getQuoteValueByHour().add(quoteValue);

            for (QuoteValueRaw quoteValueRaw : quoteRaw.getQuoteValues()) {

                switch (quoteValueRaw.getTLabel()) {
                    case ORDER:
                        quoteValue.setHour(Integer.parseInt(quoteValueRaw.getValue()));
                        break;
                    case NET_VOLUME:
                        quoteValue.setNetVolume(Double.parseDouble(quoteValueRaw.getValue()));
                        break;
                    case PRICE:
                        quoteValue.setPrice(Double.parseDouble(quoteValueRaw.getValue()));
                        break;
                    default:
                        break;
                }
            }
        }
        return returnQuoteResponse;
    }
}
