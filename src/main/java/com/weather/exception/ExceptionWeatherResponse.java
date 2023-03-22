package com.weather.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionWeatherResponse {
    private String message;
    private LocalDateTime localDateTime;

    public ExceptionWeatherResponse(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }

}