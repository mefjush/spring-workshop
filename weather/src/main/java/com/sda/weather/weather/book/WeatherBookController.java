package com.sda.weather.weather.book;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherBookController {

    private final WeatherBookRepository weatherBookRepository;

    public WeatherBookController(WeatherBookRepository weatherBookRepository) {
        this.weatherBookRepository = weatherBookRepository;
    }

    @GetMapping("/weather/book")
    public String custom(@Param("location") String location, @Param("temperature") int temperature, @Param("scale") String scale) {
        weatherBookRepository.saveWeatherBook(location, temperature, scale);
        return "weather-book";
    }
}
