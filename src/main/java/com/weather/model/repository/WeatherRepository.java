package com.weather.model.repository;

import com.weather.model.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    @Query(value = "select w from Weather w where w.createdAt=(select max(createdAt) from Weather)")
    Optional<Weather> findByTheLastInsert();

    @Query("select avg(w.temperature) from Weather w where date(w.createdAt) between :from and :to group by date(w.createdAt)")
    Optional<List<Double>> findAverageTemperature(Date from, Date to);

}
