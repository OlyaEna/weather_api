package com.weather.dto.api;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
