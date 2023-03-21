package com.weather.service;

import com.weather.dto.WeatherDto;
import com.weather.model.entity.Weather;

public interface WeatherService {
    Weather getWeatherViaWeatherAPIAndSaveToDB();
    WeatherDto findTheLastSelect();

    WeatherDto findById(Long id);
}
