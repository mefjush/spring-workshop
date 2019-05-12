package pl.sda.kantor.api;

import pl.sda.kantor.rate.Rate;

public class BuySell {
    public Double buy;
    public Double sell;

    public BuySell(Rate rate) {
        this.buy = rate.getBuyRate();
        this.sell = rate.getSellRate();
    }
}
