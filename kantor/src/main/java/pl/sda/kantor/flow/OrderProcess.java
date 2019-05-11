package pl.sda.kantor.flow;

import java.io.Serializable;

public class OrderProcess implements Serializable {

    private String currency;
    private String value;

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public String getValue() {
        return value;
    }
}
