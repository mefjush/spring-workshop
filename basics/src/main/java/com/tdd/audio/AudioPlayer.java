package com.tdd.audio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.spring.RandomNumberGenerator;
import pl.sda.spring.Sleep;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;

public class AudioPlayer {

    private final Logger logger = LoggerFactory.getLogger(RandomNumberGenerator.class);

    public static final String FANFARE = "/fanfare.wav";
    public static final String CAT = "/cat.wav";

    public AudioPlayer() {
        logger.info("Creating AudioPlayer");
        Sleep.sleep();
    }

    public void play(String soundFile) {
        InputStream soundStream = getClass().getResourceAsStream(soundFile);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundStream);
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
