package com.weather.controllers;

import com.weather.exception.ExceptionWeatherResponse;
import com.weather.exception.InvalidDateException;
import com.weather.exception.TheLastWeatherNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(TheLastWeatherNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionWeatherResponse catchTheLastNotFoundException(TheLastWeatherNotFoundException exception) {
        log.error(exception.getMessage());
        return new ExceptionWeatherResponse(exception.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(InvalidDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionWeatherResponse catchInvalidDateException(InvalidDateException exception) {
        log.error(exception.getMessage());
        return new ExceptionWeatherResponse(exception.getMessage(), LocalDateTime.now());
    }

}
