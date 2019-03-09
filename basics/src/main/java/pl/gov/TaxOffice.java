package pl.gov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.utils.Sleep;

public class TaxOffice {

    private final Logger logger = LoggerFactory.getLogger(TaxOffice.class);

    public TaxOffice() {
        logger.info("Creating TaxOffice");
        Sleep.sleep();
    }

    public void notifyPrizeWon(String prize, Integer pln) {
        logger.info("Zaraportowano do urzędu wygraną nagrody " + prize + " o wartości " + pln + "zł.");
    }

    public void notifyLargeTransaction(String description, Integer pln) {
        logger.info("Zaraportowano dużą transakcję: " + description + " na kwotę " + pln + "zł.");
    }

    public void notifyCurrencyExchange(String currency, Integer amount) {
        logger.info("Zaraportowano do urzędu wymianę waluty " + currency + " w ilości " + amount + " jednostek.");
    }
}
