package com.weather.dto.mapper;

import com.weather.dto.WeatherDto;
import com.weather.model.entity.Weather;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
@Data
public class WeatherMapper {
    private ModelMapper modelMapper;

    public Weather toEntity(WeatherDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Weather.class);
    }

    public WeatherDto toDto(Weather entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, WeatherDto.class);
    }

    public List<WeatherDto> listToDto(List<Weather> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<WeatherDto>>() {
        }.getType());
    }


}
