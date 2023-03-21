package com.weather.dto.api;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Wind {
    private double speed;
    private int deg;
    private double gust;
}