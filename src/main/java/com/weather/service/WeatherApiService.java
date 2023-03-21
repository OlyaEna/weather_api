package com.weather.service;

import com.weather.dto.api.WeatherApiResponseDto;

public interface WeatherApiService {
    WeatherApiResponseDto getWeatherApiResponse() throws Exception;
}
