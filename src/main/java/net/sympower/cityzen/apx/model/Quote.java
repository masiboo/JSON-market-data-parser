package net.sympower.cityzen.apx.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Quote {
    private Long date;
    private List<QuoteValue> quoteValueByHour = new ArrayList<>();
}
