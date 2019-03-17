package com.sda.kantor.weather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

    private String locationName;
    private int temperature;

    @JsonCreator
    public Weather(@JsonProperty("name") String locationName, @JsonProperty("temperature") int temperature) {
        this.locationName = locationName;
        this.temperature = temperature;
    }

    public String getLocationName() {
        return locationName;
    }

    public int getTemperature() {
        return temperature;
    }
}
