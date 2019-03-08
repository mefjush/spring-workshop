package pl.sda.spring.lotteries;

public interface Lottery {

    int getTicketCost();

    String getPrize();

    default String getName() {
        return this.getClass().getSimpleName();
    }
}
