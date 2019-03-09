package pl.sda.lottery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.utils.Sleep;

import java.security.SecureRandom;

public class RandomNumberGenerator {

    private final Logger logger = LoggerFactory.getLogger(RandomNumberGenerator.class);

    private SecureRandom secureRandom = new SecureRandom();

    public RandomNumberGenerator() {
        logger.info("Creating RandomNumberGenerator");
        Sleep.sleep();
    }

    public int randomInt(int size) {
        return secureRandom.nextInt(size);
    }
}
