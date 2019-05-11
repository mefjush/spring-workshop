package pl.sda.kantor.rate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyCheckRepositoryTest {

    @Autowired
    private CurrencyCheckRepository currencyCheckRepository;

    CurrencyCheck eur100currencyCheck = new CurrencyCheck();

    @Before
    public void setUp() throws Exception {
        eur100currencyCheck.setTimestamp(0);
        eur100currencyCheck.setAmount(100d);
        eur100currencyCheck.setCurrency("EUR");
    }

    @Test
    public void currency_check_is_saved_to_db() {
        //given
        currencyCheckRepository.save(eur100currencyCheck);

        //when
        long count = currencyCheckRepository.count();

        //then
        assertThat(count, is(1L));
    }

    @Test
    public void gets_eur_checks() {
        currencyCheckRepository.save(eur100currencyCheck);

        long eurChecks = currencyCheckRepository.countByCurrency("EUR");

        assertThat(eurChecks, is(1L));
    }

    @Test
    public void noUSDchecksReported() {
        currencyCheckRepository.save(eur100currencyCheck);

        long eurChecks = currencyCheckRepository.countByCurrency("USD");

        assertThat(eurChecks, is(0L));
    }
}