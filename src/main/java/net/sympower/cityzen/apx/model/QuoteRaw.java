package net.sympower.cityzen.apx.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class QuoteRaw {
    @JsonProperty("date_applied")
    private Long dateApplied;
    @JsonProperty("values")
    public List<QuoteValueRaw> quoteValues;
}
