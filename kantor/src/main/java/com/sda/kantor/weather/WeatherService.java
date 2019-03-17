package com.sda.kantor.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {

    /*
    https://www.mocky.io/
    http://www.mocky.io/v2/5c8e7a9d3000000d001b0e5b

    { "weatherList": [
      { "name": "Warsaw", "temperature": 20 },
      { "name": "Wroclaw", "temperature": 30 },
      { "name": "Bialystok", "temperature": -10 }
    ]}
    */

    private final RestTemplate restTemplate;

    public WeatherService() {
        //TODO this can be converted to a Bean
        this.restTemplate = new RestTemplate();
    }

    public List<Weather> getWeatherList() {
        //TODO String response will also work but will require manual parsing
        WeatherResponse weatherResponse = restTemplate.getForObject("http://www.mocky.io/v2/5c8e7a9d3000000d001b0e5b", WeatherResponse.class);
        return weatherResponse.weatherList;
    }

    private static class WeatherResponse {
        public List<Weather> weatherList;
    }
}
