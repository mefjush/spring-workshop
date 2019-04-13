package pl.sda.lottery.lotteries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.audio.AudioPlayer;

@Service
public class PenLottery implements Lottery {

    private AudioPlayer audioPlayer;

    @Autowired
    public PenLottery(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public int getTicketCost() {
        return 1;
    }

    @Override
    public String getPrize() {
        audioPlayer.play(AudioPlayer.FANFARE);
        return "[pen]";
    }
}
