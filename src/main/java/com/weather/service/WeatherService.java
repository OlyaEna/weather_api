package com.weather.service;

import com.weather.dto.TempRequest;
import com.weather.dto.TempResponse;
import com.weather.dto.WeatherDto;
import java.util.List;

public interface WeatherService {
    void saveWeatherToDB();

    WeatherDto findByTheLastInsert();
    List<TempResponse> findAverageDailyTemp(TempRequest tempRequest);
}
