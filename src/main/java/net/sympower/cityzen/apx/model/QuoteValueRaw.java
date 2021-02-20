package net.sympower.cityzen.apx.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuoteValueRaw {

    @JsonProperty("tLabel")
    private String tLabel;
    private String value;

    public QuoteValueRaw() {

    }
}
