package pl.sda.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;

public class RandomNumberGenerator {

    private final Logger logger = LoggerFactory.getLogger(RandomNumberGenerator.class);

    private SecureRandom secureRandom = new SecureRandom();

    public RandomNumberGenerator() {
        init();
        logger.info("Creating RandomNumberGenerator");
    }

    private void init() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int randomInt(int size) {
        return secureRandom.nextInt(size);
    }
}
