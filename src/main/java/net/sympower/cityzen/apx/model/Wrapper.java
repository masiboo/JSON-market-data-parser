package net.sympower.cityzen.apx.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class Wrapper {

    @JsonProperty("quote")
    List<Quote> quotes;

}
