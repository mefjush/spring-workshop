package com.sda.kantor.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    private final RestTemplate restTemplate;
    private final int temperatureAdjustmentPercent;

    public WeatherService(@Value("${weather.temperature.adjustment.percent}") int temperatureAdjustmentPercent) {
        this.temperatureAdjustmentPercent = temperatureAdjustmentPercent;
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

    private static class WeatherResponse {
        public List<Weather> weatherList;
    }
}
