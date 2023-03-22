package com.weather.exception;


public class TheLastWeatherNotFoundException extends RuntimeException {
    public TheLastWeatherNotFoundException(String message) {
        super(message);
    }
}
