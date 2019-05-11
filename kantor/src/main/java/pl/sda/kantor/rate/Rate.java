package pl.sda.kantor.rate;

public class Rate {
    private String name;
    private double rate;
    private double spread;

    public Rate(String name, double rate, double spread) {
        this.name = name;
        this.rate = rate;
        this.spread = spread;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public double getSellRate() {

        return ((100 + spread) * rate) / 100;
    }

    public double getBuyRate() {
        return ((100 - spread) * rate) / 100;
    }
}
