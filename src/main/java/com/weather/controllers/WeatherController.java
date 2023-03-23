package com.weather.controllers;

import com.weather.dto.TempRequest;
import com.weather.dto.TempResponse;
import com.weather.dto.WeatherDto;
import com.weather.exception.InvalidDateException;
import com.weather.model.repository.WeatherRepository;
import com.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@AllArgsConstructor
@RestController
@EnableScheduling
public class WeatherController {
    private final WeatherService weatherService;
    private final WeatherRepository weatherRepository;


    /**
     * Информация о последней записи о погоде в БД
     */
    @GetMapping(path = "/current")
    public WeatherDto getCurrentWeather() {
        return weatherService.findByTheLastInsert();
    }


    /**
     * Информация о среднесуточной температуре,
     * рассчитанная на основании имеющихся в сервисе данных
     */

    @PostMapping("/temperature")
    public List<TempResponse> getAvgTemp(@RequestBody TempRequest tempRequest) {
        return weatherService.findAverageDailyTemp(tempRequest);
    }

    /**
     * Дополнительная реализация через @GetMapping
     * Информация о среднесуточной температуре,
     * рассчитанная на основании имеющихся в сервисе данных
     */
    @GetMapping(path = "/find")
    public List<Double> findByDateBetween(@RequestParam(name = "from") Date from,
                                          @RequestParam(name = "to") Date to) {
        return weatherRepository.findAverageTemperature(from, to).orElseThrow(() ->
                new InvalidDateException("Data is incorrect"));
    }

}