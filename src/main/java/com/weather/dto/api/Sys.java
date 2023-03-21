package com.weather.dto.api;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Sys {
    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;
}