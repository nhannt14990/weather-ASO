package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Weather;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Integer>{
	List<Weather> findByNameCity(String cityName);
	
	List<Weather> findByIdCity(Integer idCity);
	
	@Query("SELECT u FROM Weather u WHERE u.nameCity like ?1 order by nameCity desc")
	List<Weather> findByNameCityForWeb(String cityName);
}
