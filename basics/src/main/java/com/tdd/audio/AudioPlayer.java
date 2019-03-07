package com.tdd.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;

public class AudioPlayer {

    public static final String FANFARE = "/fanfare.wav";
    public static final String CAT = "/cat.wav";

    public void play(String soundFile) {
        InputStream soundStream = getClass().getResourceAsStream(soundFile);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundStream);
//            Clip clip = AudioSystem.getClip();
            DataLine.Info info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioIn);
            clip.start();
            clip.addLineListener(event -> {
                if (event.getType().equals(LineEvent.Type.STOP)) {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
        } catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
}
