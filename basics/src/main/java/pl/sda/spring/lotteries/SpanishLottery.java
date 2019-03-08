package pl.sda.spring.lotteries;

import com.tdd.audio.AudioPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.spring.RandomNumberGenerator;

public class SpanishLottery implements Lottery {

    private final Logger logger = LoggerFactory.getLogger(SpanishLottery.class);

    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private AudioPlayer audioPlayer = new AudioPlayer();

    public SpanishLottery() {
        logger.info("Creating " + getName());
    }

    @Override
    public int getTicketCost() {
        return 30;
    }

    public String getPrize() {
        int number = randomNumberGenerator.randomInt(10);
        if (number == 7 || number == 8) {
            String prize = number == 7 ? "SALSA" : "TEQUILA";
            audioPlayer.play(AudioPlayer.FANFARE);
            return prize;
        }
        return "[nada]";
    }
}
