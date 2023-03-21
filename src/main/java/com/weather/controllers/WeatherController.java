package com.weather.controllers;

import com.weather.dto.WeatherDto;
import com.weather.model.entity.Weather;
import com.weather.model.repository.WeatherRepository;
import com.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RestController
@EnableScheduling
public class WeatherController {
    private final WeatherService weatherService;
    private final WeatherRepository weatherRepository;

    @Scheduled(cron = "${interval-in-cron}")
    @GetMapping(path = "/now")
    public  Weather getCurrentWeather() {
        return weatherService.getWeatherViaWeatherAPIAndSaveToDB();
    }

    @GetMapping(path = "/{id}")
    public  WeatherDto getById(@PathVariable(name = "id") Long id) {
        return weatherService.findById(id);
    }

    @GetMapping(path = "/last")
    public WeatherDto getTheLastSelect() {
        return weatherService.findTheLastSelect();
    }




}