package com.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {
    @JsonIgnore
    private Long id;
    private Double temperature;
    private Double wind;
    private Double pressure;
    private Double humidity;
    private String  conditions;
    private String  location;
    @JsonIgnore
    private LocalDateTime createdAt;
}
