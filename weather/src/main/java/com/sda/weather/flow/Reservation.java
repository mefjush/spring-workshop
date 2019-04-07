package com.sda.weather.flow;

import java.io.Serializable;

public class Reservation implements Serializable {

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
