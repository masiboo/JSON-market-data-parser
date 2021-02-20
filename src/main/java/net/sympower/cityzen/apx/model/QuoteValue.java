package net.sympower.cityzen.apx.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuoteValue {

    private String tLabel;
    private String cLabel;
    private String value;
    private String unit;
    private int position;
    private boolean chartShow;
    private String chartType;
    private String color;
    private int precision;

    public QuoteValue() {

    }
}
