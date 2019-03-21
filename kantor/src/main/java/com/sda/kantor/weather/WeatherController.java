package com.sda.kantor.weather;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class WeatherController {

    private final WeatherService weatherService;
    private final WeatherCheckRepository weatherCheckRepository;
    private final SmartWeatherCheckRepository smartWeatherCheckRepository;

    public WeatherController(WeatherService weatherService, WeatherCheckRepository weatherCheckRepository, SmartWeatherCheckRepository smartWeatherCheckRepository) {
        this.weatherService = weatherService;
        this.weatherCheckRepository = weatherCheckRepository;
        this.smartWeatherCheckRepository = smartWeatherCheckRepository;
    }

    @GetMapping("/weather/simple")
    public ModelAndView weather() {
        ModelAndView modelAndView = new ModelAndView("weather");
        List<Weather> weatherList = Arrays.asList(
                new Weather("Wroclaw", 30),
                new Weather("Warszawa", 15),
                new Weather("Opole", 22)
        );
        modelAndView.addObject(weatherList);
        return modelAndView;
    }

    @GetMapping("/weather")
    public ModelAndView wth() {
        List<Weather> weatherList = weatherService.getWeatherList();
        ModelAndView modelAndView = new ModelAndView("weather");
        modelAndView.addObject(weatherList);
        return modelAndView;
    }

    @GetMapping("/weather/details")
    public ModelAndView custom(@Param("location") String location, @Param("scale") String scale) {
//        weatherCheckRepository.saveWeatherCheck(location, scale);
        smartWeatherCheckRepository.save(new WeatherCheck(location, scale));
        List<Weather> weatherList = weatherService.getWeatherList();
        for (Weather weather : weatherList) {
            if (weather.getLocationName().equals(location)) {
                if (scale.equals("F")) {
                    weather = new Weather(weather.getLocationName(), celciusToFarenheit(weather));
                }
                ModelAndView modelAndView = new ModelAndView("weather-details");
                modelAndView.addObject("weather", weather);
                modelAndView.addObject("scale", scale);
                return modelAndView;
            }
        }
        throw new RuntimeException("No such location!");
    }

    private int celciusToFarenheit(Weather weather) {
        return weather.getTemperature() * 9 / 5 + 32;
    }
}
