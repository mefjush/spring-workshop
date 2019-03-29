package com.sda.kantor.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    /*
    https://www.mocky.io/
    http://www.mocky.io/v2/5c8e7a9d3000000d001b0e5b

    { "weatherList": [
      { "name": "Warszawa", "temperature": 20 },
      { "name": "Wroclaw", "temperature": 30 },
      { "name": "Bialystok", "temperature": -10 }
    ]}
    */

    private static final String DEFAULT_SCALE = "C";

    private final RestTemplate restTemplate;
    private final int temperatureAdjustmentPercent;
    private final SmartWeatherCheckRepository smartWeatherCheckRepository;

    public WeatherService(@Value("${weather.temperature.adjustment.percent}") int temperatureAdjustmentPercent, SmartWeatherCheckRepository smartWeatherCheckRepository) {
        this.temperatureAdjustmentPercent = temperatureAdjustmentPercent;
        this.smartWeatherCheckRepository = smartWeatherCheckRepository;
        //TODO this can be converted to a Bean
        this.restTemplate = new RestTemplate();
    }

    public List<Weather> getWeatherList() {
        //TODO String response will also work but will require manual parsing
        WeatherResponse weatherResponse = restTemplate.getForObject("http://www.mocky.io/v2/5c8e7a9d3000000d001b0e5b", WeatherResponse.class);
        List<Weather> originalWeather = weatherResponse.weatherList;
        List<Weather> adjustedWeather = originalWeather.stream()
                .map(w -> new Weather(w.getLocationName(), adjustTemperature(w.getTemperature())))
                .collect(Collectors.toList());
        return adjustedWeather;
    }

    private int adjustTemperature(int temperature) {
        return temperature + (temperature * temperatureAdjustmentPercent) / 100;
    }

    @Transactional
    public List<Weather> getComparizon(String location1, String location2) {
        List<String> locations = Arrays.asList(location1, location2);
        smartWeatherCheckRepository.save(new WeatherCheck(location1, DEFAULT_SCALE));
        smartWeatherCheckRepository.save(new WeatherCheck(location2, DEFAULT_SCALE));
        List<Weather> weatherList = getWeatherList();
        List<Weather> list = weatherList.stream()
                .filter(w -> locations.contains(w.getLocationName()))
                .collect(Collectors.toList());
        if (list.size() != 2) {
            throw new RuntimeException("Could not create comparizon for " + location1 + " and " + location2);
        }
        return list;
    }

    private static class WeatherResponse {
        public List<Weather> weatherList;
    }
}
