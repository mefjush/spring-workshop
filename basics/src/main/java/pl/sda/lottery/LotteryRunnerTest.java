package pl.sda.lottery;

import pl.gov.TaxOffice;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LotteryRunnerTest {

    @Test
    public testLotteryRunner() {
        LotteryRunner lotteryRunner = new LotteryRunner(new ArrayList<>(), new TaxOffice());
    }

}