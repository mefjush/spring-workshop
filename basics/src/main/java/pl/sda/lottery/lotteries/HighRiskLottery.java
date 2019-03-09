package pl.sda.lottery.lotteries;

import pl.sda.lottery.AudioPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.gov.TaxOffice;
import pl.sda.lottery.RandomNumberGenerator;

public class HighRiskLottery implements Lottery {

    private final Logger logger = LoggerFactory.getLogger(HighRiskLottery.class);

    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private AudioPlayer audioPlayer = new AudioPlayer();
    private TaxOffice taxOffice = new TaxOffice();

    public HighRiskLottery() {
        logger.info("Creating " + getName());
    }

    @Override
    public int getTicketCost() {
        return 100;
    }

    public String getPrize() {
        if (randomNumberGenerator.randomInt(20_000) == 7) {
            String prize = "CAR";
            audioPlayer.play(AudioPlayer.FANFARE);
            taxOffice.notifyPrizeWon(prize, 100_000);
            return prize;
        }
        return "[nothing]";
    }
}
