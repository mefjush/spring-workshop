package pl.sda.lottery.lotteries;

import pl.sda.audio.AudioPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.gov.TaxOffice;
import pl.sda.lottery.RandomNumberGenerator;

public class LowRiskLottery implements Lottery {

    private final Logger logger = LoggerFactory.getLogger(LowRiskLottery.class);

    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private AudioPlayer audioPlayer = new AudioPlayer();
    private TaxOffice taxOffice = new TaxOffice();

    public LowRiskLottery() {
        logger.info("Creating " + getName());
    }

    @Override
    public int getTicketCost() {
        return 1;
    }

    public String getPrize() {
        if (randomNumberGenerator.randomInt(10) == 7) {
            String prize = "MUG";
            audioPlayer.play(AudioPlayer.FANFARE);
            taxOffice.notifyPrizeWon(prize, 10);
            return prize;
        }
        return "[nothing]";
    }
}
