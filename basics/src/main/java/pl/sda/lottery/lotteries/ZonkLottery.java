package pl.sda.lottery.lotteries;

import pl.sda.audio.AudioPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZonkLottery implements Lottery {

    private final Logger logger = LoggerFactory.getLogger(ZonkLottery.class);

    private AudioPlayer audioPlayer = new AudioPlayer();

    public ZonkLottery() {
        logger.info("Creating " + getName());
    }

    @Override
    public int getTicketCost() {
        return 5;
    }

    public String getPrize() {
        audioPlayer.play(AudioPlayer.CAT);
        return "[zonk]";
    }
}
