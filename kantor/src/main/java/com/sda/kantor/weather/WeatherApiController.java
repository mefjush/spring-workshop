package com.sda.kantor.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherApiController {

    private final WeatherService weatherService;

    public WeatherApiController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather/{location}")
    Weather weather(@PathVariable String location) {
        List<Weather> weatherList = weatherService.getWeatherList();
        Weather weather = weatherList.stream()
                .filter(w -> w.getLocationName().equals(location)).findFirst()
                .orElseThrow(() -> new RuntimeException("No weather for " + location + " found!"));
        return weather;
    }
}
