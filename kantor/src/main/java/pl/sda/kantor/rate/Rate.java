package pl.sda.kantor.rate;

public class Rate {
    private String name;
    private double rate;
    private double spreadPercent;

    public Rate(String name, double rate, double spreadPercent) {
        this.name = name;
        this.rate = rate;
        this.spreadPercent = spreadPercent;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public double getSell() {
        return rate * (100 + spreadPercent) / 100;
    }

    public double getBuy() {
        return rate * (100 - spreadPercent) / 100;
    }
}
