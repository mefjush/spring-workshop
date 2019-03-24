package com.sda.kantor;

import com.sda.kantor.weather.SmartWeatherCheckRepository;
import com.sda.kantor.weather.WeatherCheck;
import com.sda.kantor.weather.WeatherCheckRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional for auto rollback  /* has to be InnoDb: show table status where name = "weather_check"; */
public class KantorApplicationTests {

	@Autowired
	WeatherCheckRepository weatherCheckRepository;

	@Autowired
	SmartWeatherCheckRepository smartWeatherCheckRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void storesWeatherChecksInTheDb() {
		weatherCheckRepository.saveWeatherCheck("Lublin", "C");

		List<WeatherCheck> lublinChecks = smartWeatherCheckRepository.findByLocation("Lublin");

		assertTrue(lublinChecks.contains(new WeatherCheck("Lublin", "C")));
	}

}
