package com.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
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
