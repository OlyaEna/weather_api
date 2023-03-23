package com.weather.services;

import com.weather.dto.WeatherDto;
import com.weather.dto.mapper.WeatherMapper;
import com.weather.model.entity.Weather;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTest {
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertWeatherEntityToWeatherDto_thenCorrect() {
        Weather weather = createWeather();
        WeatherDto weatherDto = modelMapper.map(weather, WeatherDto.class);


        assertEquals(weather.getId(), weatherDto.getId());
        assertEquals(weather.getTemperature(), weatherDto.getTemperature());
        assertEquals(weather.getWind(), weatherDto.getWind());
        assertEquals(weather.getHumidity(), weatherDto.getHumidity());
        assertEquals(weather.getPressure(), weatherDto.getPressure());
        assertEquals(weather.getConditions(), weatherDto.getConditions());
        assertEquals(weather.getLocation(), weatherDto.getLocation());
        assertEquals(weather.getCreatedAt(), weatherDto.getCreatedAt());


    }

    public Weather createWeather() {
        return Weather.builder()
                .id(149L)
                .temperature(5.86)
                .wind(4.05)
                .pressure(1010.0)
                .humidity(90.0)
                .conditions("overcast clouds")
                .location("Minsk")
                .createdAt(LocalDateTime.of(2023, 3, 16, 12, 00))
                .build();
    }
}
