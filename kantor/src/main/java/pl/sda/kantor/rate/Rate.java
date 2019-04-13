package pl.sda.kantor.rate;

public class Rate {
    private String name;
    private double rate;

    public Rate(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }
}
