package pl.sda.spring;

import com.tdd.audio.AudioPlayer;
import pl.gov.TaxOffice;

public class Lottery {

    private LotteryTicketRepository lotteryTicketRepository = new LotteryTicketRepository();
    private AudioPlayer audioPlayer = new AudioPlayer();
    private TaxOffice taxOffice = new TaxOffice();

    public String getPrize() {
        LotteryTicket lotteryTicket = lotteryTicketRepository.getTicket();
        if (lotteryTicket.equals(LotteryTicket.BLANK)) {
            audioPlayer.play(AudioPlayer.CAT);
            return "[nothing]";
        }
        String prizeName = lotteryTicket.name();
        audioPlayer.play(AudioPlayer.FANFARE);
        taxOffice.notifyPrizeWon(prizeName, 1000);
        return prizeName;
    }
}
