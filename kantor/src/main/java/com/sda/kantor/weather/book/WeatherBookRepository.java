package com.sda.kantor.weather.book;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherBookRepository {

    /*
    create table weather.weather_book(id SERIAL, location VARCHAR(255), temperature INT, scale VARCHAR(1));
     */

    private final JdbcTemplate jdbcTemplate;

    public WeatherBookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveWeatherBook(String location, int temperature, String scale) {
        jdbcTemplate.update("INSERT INTO weather_book (location, temperature, scale) VALUES (?, ?, ?)", location, temperature, scale);
    }
}
