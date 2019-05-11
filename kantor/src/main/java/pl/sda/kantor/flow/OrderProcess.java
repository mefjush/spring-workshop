package pl.sda.kantor.flow;

import java.io.Serializable;

public class OrderProcess implements Serializable {

    private String currency;
    private String value;
    private String rate;

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public String getValue() {
        return value;
    }

    public String getRate() {
        return rate;
    }
}
