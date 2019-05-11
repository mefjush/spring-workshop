package pl.sda.kantor.rate;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RateTest {

    @Test
    public void calculates_sell_rate() {
        //given
        Rate rate = new Rate("EUR", 4, 10);

        //when
        double sellRate = rate.getSellRate();

        //then
        assertThat(sellRate, is(4.4d));
    }
}