package pl.sda.kantor.rate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

//@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyCheckRepositoryTest {

    @Autowired
    private CurrencyCheckRepository currencyCheckRepository;

    @Test
    public void currencyChecksAreBeingStored() {
        CurrencyCheck eurCheck = new CurrencyCheck();
        eurCheck.setCurrency("EUR");
        eurCheck.setAmount(100d);
        eurCheck.setTimestamp(0);
        currencyCheckRepository.save(eurCheck);

        long eurChecks = currencyCheckRepository.countByCurrency("EUR");

        assertThat(eurChecks, is(1L));
    }

    @Test
    public void mostPopularCurrencyIsUsd() {
        CurrencyCheck currencyCheck = new CurrencyCheck();
        currencyCheck.setCurrency("USD");
        currencyCheck.setAmount(100d);
        currencyCheck.setTimestamp(0);
        currencyCheckRepository.save(currencyCheck);

        List<String> currency = currencyCheckRepository.getMostPopularCurrency();

        assertThat(currency, is(Collections.singletonList("USD")));
    }
}