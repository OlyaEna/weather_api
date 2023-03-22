package com.weather.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weather.dto.TempRequest;
import com.weather.dto.TempResponse;
import com.weather.dto.WeatherDto;
import com.weather.dto.api.WeatherApiResponseDto;
import com.weather.dto.mapper.WeatherMapper;
import com.weather.exception.InvalidDateException;
import com.weather.exception.TheLastWeatherNotFoundException;
import com.weather.model.entity.Weather;
import com.weather.model.repository.WeatherRepository;
import com.weather.service.WeatherApiService;
import com.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@EnableScheduling
public class WeatherServiceImpl implements WeatherService {
    private final WeatherMapper weatherMapper;
    private final WeatherRepository weatherRepository;
    private final WeatherApiService weatherApiService;


    @Override
    @Scheduled(cron = "${interval-in-cron}")
    public void saveWeatherToDB() {
        WeatherApiResponseDto weatherApiResponseDto = null;
        try {
            weatherApiResponseDto = weatherApiService.getWeatherApiResponse();
            log.info("Got response from openweathermap");
        }catch (JsonProcessingException e) {
            log.error("Error occurred while parsing response"+ e.getMessage());
        } catch (Exception e) {
            log.error("Error occurred while getting response" + e.getMessage());
        }
        Weather weather = weatherApiResponseDtoToWeather(weatherApiResponseDto);
        weatherRepository.save(weather);
        log.info("Weather saved");
    }


    @Override
    public WeatherDto findByTheLastInsert() {
        log.info("Found by last saved response ");
        return weatherMapper.toDto(weatherRepository.findByTheLastInsert().orElseThrow(() ->
                new TheLastWeatherNotFoundException("weather information not found")));
    }

    public List<TempResponse> findAverageDailyTemp(TempRequest tempRequest) {
        List<Double> averageTemp = weatherRepository.findAverageTemperature(tempRequest.getFrom(), tempRequest.getTo()).orElseThrow(() ->
                new InvalidDateException("Data is incorrect"));
        log.info("Found by saved response ");
        return convertToResponse(averageTemp);
    }

    private Weather weatherApiResponseDtoToWeather(WeatherApiResponseDto weatherApiResponse) {
        Weather weather = new Weather();
        if (weatherApiResponse != null) {
            weather.setTemperature(weatherApiResponse.getMain().getTemp());
            weather.setHumidity(weatherApiResponse.getMain().getHumidity());
            weather.setPressure(weatherApiResponse.getMain().getPressure());
            weather.setWind(weatherApiResponse.getWind().getSpeed());
            weather.setConditions(weatherApiResponse.getWeather().get(0).getDescription());
            weather.setLocation(weatherApiResponse.getName());
        }
        return weather;
    }

    private List<TempResponse> convertToResponse(List<Double> averageTemps) {
        List<TempResponse> tempResponseList = new ArrayList<>();
        for (Double averageTemp : averageTemps) {
            TempResponse tempResponse = new TempResponse();
            tempResponse.setAverageTemp(averageTemp);
            tempResponseList.add(tempResponse);
        }
        return tempResponseList;
    }
}
