package net.sympower.cityzen.apx;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.sympower.cityzen.apx.model.Quote;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class QuoteResponse {
    private final List<Quote> quotes = new ArrayList<>();
}
