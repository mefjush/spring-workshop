package pl.sda.kantor.order;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrencyOrder {

    @Id
    @GeneratedValue
    private Integer id;

    private String currency;
    private Double value;
    private String user;
    private Double rate;

    public CurrencyOrder(String currency, Double value, String user, Double rate) {
        this.currency = currency;
        this.value = value;
        this.user = user;
        this.rate = rate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getValue() {
        return value;
    }

    public String getUser() {
        return user;
    }

    public Double getRate() {
        return rate;
    }
}
