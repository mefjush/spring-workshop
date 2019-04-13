package pl.sda.lottery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.sda.utils.Sleep;

import java.security.SecureRandom;

@Component
@Scope("session")
public class RandomNumberGenerator {

    private final Logger logger = LoggerFactory.getLogger(RandomNumberGenerator.class);

    private SecureRandom secureRandom;

    @Autowired
    public RandomNumberGenerator(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
        logger.info("Creating RandomNumberGenerator");
        Sleep.sleep();
    }

    public int randomInt(int size) {
        return secureRandom.nextInt(size);
    }
}
