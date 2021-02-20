package net.sympower.cityzen.apx;

import lombok.Getter;
import lombok.Setter;
import net.sympower.cityzen.apx.model.Quote;

import java.util.List;

@Setter
@Getter
public class QuoteResponse {
    private List<Quote> quote;
    public QuoteResponse(List<Quote> quotes) {
        this.quote = quotes;
    }
}
