package net.sympower.cityzen.apx.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Quote {

    private String market;
    @JsonProperty("date_applied")
    private String dateApplied;
    @JsonProperty("values")
    public List<QuoteValue> quoteValues;
}
