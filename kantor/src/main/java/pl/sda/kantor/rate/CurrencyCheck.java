package pl.sda.kantor.rate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrencyCheck {

    @Id
    @GeneratedValue
    private Integer id;

    private long timestamp;
    private String currency;
    private Double amount;

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
