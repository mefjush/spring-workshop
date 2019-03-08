package pl.sda.spring;

import com.tdd.audio.AudioPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.gov.TaxOffice;

public class Lottery {

    private final Logger logger = LoggerFactory.getLogger(Lottery.class);

    private LotteryTicketRepository lotteryTicketRepository = new LotteryTicketRepository();
    private AudioPlayer audioPlayer = new AudioPlayer();
    private TaxOffice taxOffice = new TaxOffice();

    public Lottery(String countryCode) {
        logger.info("Creating Lottery for " + countryCode);
    }

    public String getPrize() {
        LotteryTicket lotteryTicket = lotteryTicketRepository.getTicket();
        if (lotteryTicket.equals(LotteryTicket.BLANK)) {
            return "[nothing]";
        }
        String prizeName = lotteryTicket.name();
        audioPlayer.play(AudioPlayer.FANFARE);
        taxOffice.notifyPrizeWon(prizeName, lotteryTicket.getValue());
        return prizeName;
    }
}
