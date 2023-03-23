package com.weather.service.impl;

import com.weather.dto.api.WeatherApiResponseDto;
import com.weather.service.WeatherApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
public class WeatherApiServiceImpl implements WeatherApiService {

    private @Value("${openweathermap.API.KEY}") String API_KEY;
    private @Value("${openweathermap.API.WEATHER.URI}") String API_URI;
    private @Value("${openweathermap.API.CITY}") String API_CITY;


    private URI weatherURIBuilder() {
        return UriComponentsBuilder.fromHttpUrl(API_URI)
                .replaceQueryParam("appid", API_KEY)
                .replaceQueryParam("q", API_CITY)
                .build()
                .toUri();
    }


    public WeatherApiResponseDto getWeatherApiResponse() throws Exception {

        String url = String.valueOf(weatherURIBuilder());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeatherApiResponseDto> response = restTemplate.getForEntity(url, WeatherApiResponseDto.class);
        if (response.getStatusCode().isError()) {
            throw new Exception();
        }
        return response.getBody();
    }
}
