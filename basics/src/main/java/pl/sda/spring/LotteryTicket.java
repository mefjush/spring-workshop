package pl.sda.spring;

public enum LotteryTicket {

    BLANK(0), TV(5000), PEN(1), CAR(100_000);

    private final int value;

    LotteryTicket(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
