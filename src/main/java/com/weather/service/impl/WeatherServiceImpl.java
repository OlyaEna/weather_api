package com.weather.service.impl;

import com.weather.dto.WeatherDto;
import com.weather.dto.api.WeatherApiResponseDto;
import com.weather.dto.mapper.WeatherMapper;
import com.weather.model.entity.Weather;
import com.weather.model.repository.WeatherRepository;
import com.weather.service.WeatherApiService;
import com.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherMapper weatherMapper;
    private final WeatherRepository weatherRepository;
    private final WeatherApiService weatherApiService;


    @Override
    public Weather getWeatherViaWeatherAPIAndSaveToDB() {
        WeatherApiResponseDto weatherApiResponseDto ;
        try {
            weatherApiResponseDto = weatherApiService.getWeatherApiResponse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Weather weather = weatherApiResponseDtoToWeather(weatherApiResponseDto);
        weatherRepository.save(weather);
        return weather;
    }

    @Override
    public WeatherDto findTheLastSelect() {
        return weatherMapper.toDto(weatherRepository.findByMaxId());
    }

    @Override
    public WeatherDto findById(Long id) {
        return weatherMapper.toDto(weatherRepository.getReferenceById(id));
    }


    private Weather weatherApiResponseDtoToWeather(WeatherApiResponseDto weatherApiResponse){
        Weather weatherInfo = new Weather();
        if (weatherApiResponse != null) {
            weatherInfo.setTemperature(weatherApiResponse.getMain().getTemp());
            weatherInfo.setHumidity(weatherApiResponse.getMain().getHumidity());
            weatherInfo.setPressure(weatherApiResponse.getMain().getPressure());
            weatherInfo.setWind(weatherApiResponse.getWind().getSpeed());
            weatherInfo.setConditions(weatherApiResponse.getWeather().get(0).getDescription());
            weatherInfo.setLocation(weatherApiResponse.getName());
    }
        return weatherInfo;
    }

}
