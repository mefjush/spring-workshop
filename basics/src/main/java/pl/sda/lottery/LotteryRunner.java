package pl.sda.lottery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gov.TaxOffice;
import pl.sda.lottery.lotteries.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class LotteryRunner {


    private List<Lottery> lotteries;
    private TaxOffice taxOffice;


    @Autowired
    public LotteryRunner(List<Lottery> lotteries, TaxOffice taxOffice) {
        this.lotteries = lotteries;
        this.taxOffice = taxOffice;
    }

    @Autowired
    public void setTaxOffice(TaxOffice taxOffice) {
        this.taxOffice = taxOffice;
    }

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            Lottery lottery = promptForLottery();
            int budget = promptForBudget();
            if (budget > 500) {
                taxOffice.notifyLargeTransaction("Duza kasa na loterii", budget);
            }

            int cost = lottery.getTicketCost();
            while (cost <= budget) {
                String prize = lottery.getPrize();
                System.out.println("You've won: " + prize);
                budget -= cost;
            }
        }
    }

    private Lottery promptForLottery() {
        System.out.println("Which lottery do you want to play?");
        for (int i = 0; i < lotteries.size(); i++) {
            Lottery lottery = lotteries.get(i);
            System.out.printf("%d: %s @ %dPLN%n", i, lottery.getName(), lottery.getTicketCost());
        }
        int lotteryIndex = Integer.parseInt(scanner.nextLine());
        return lotteries.get(lotteryIndex);
    }

    private int promptForBudget() {
        System.out.println("How much money do you want to play (PLN)?");
        return Integer.parseInt(scanner.nextLine());
    }
}
