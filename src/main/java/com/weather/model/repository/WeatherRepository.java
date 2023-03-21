package com.weather.model.repository;

import com.weather.model.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

//    @Query(value = "select max(id) from weather")
//    Long findMaxId();
//    @Query(value = "select  from weather w where w.id=1")
//    Long findByTheLastSelect();

    @Query(value = "select w from Weather w where w.id=(select max(id) from Weather) ")
    Weather findByMaxId();

}
