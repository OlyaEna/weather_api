package com.weather.services;

import com.weather.dto.WeatherDto;
import com.weather.dto.mapper.WeatherMapper;
import com.weather.model.entity.Weather;
import com.weather.model.repository.WeatherRepository;
import com.weather.service.impl.WeatherServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {
    @Mock
    private WeatherRepository weatherRepository;

    @Mock
    private WeatherMapper weatherMapper;

    @InjectMocks
    private WeatherServiceImpl weatherService;


    @Test
    public void findCurrentWeatherTest() {
        Weather weather = createWeather();

        doReturn(Optional.of(weather))
                .when(weatherRepository).findByTheLastInsert();


        var actualResult = weatherService.findByTheLastInsert();

        var expected =
                new WeatherDto(149L, 5.86, 4.05, 1010.0,
                        90.0, "overcast clouds", "Minsk",
                        LocalDateTime.of(2023, 3, 16, 12, 00));

        assertEquals(expected, actualResult);

        verify(weatherRepository).findByTheLastInsert();
        verifyNoMoreInteractions(weatherRepository);
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

