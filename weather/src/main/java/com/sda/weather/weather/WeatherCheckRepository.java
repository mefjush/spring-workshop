package com.sda.weather.weather;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherCheckRepository {

    /*
    create database weather;
    create table weather.weather_check(id SERIAL, location VARCHAR(255), scale VARCHAR(1));
     */

    private final JdbcTemplate jdbcTemplate;

    public WeatherCheckRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveWeatherCheck(String location, String scale) {
        jdbcTemplate.update("INSERT INTO weather_check (location, scale) VALUES (?, ?)", location, scale);
    }
}
