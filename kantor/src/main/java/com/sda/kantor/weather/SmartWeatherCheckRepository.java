package com.sda.kantor.weather;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartWeatherCheckRepository extends CrudRepository<WeatherCheck, Integer> {

    List<WeatherCheck> findByLocation(String location);

    List<WeatherCheck> findByScaleIgnoreCaseOrderByLocationAsc(String scale);

    int countWeatherCheckByLocation(String location);

    @Query("SELECT w.location FROM WeatherCheck w GROUP BY location HAVING count(scale) > ?1")
    List<String> locationsWithAtLeastChecks(long count);

}
