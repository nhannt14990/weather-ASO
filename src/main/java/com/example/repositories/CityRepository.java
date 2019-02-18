package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.entity.City;

public interface CityRepository extends CrudRepository<City, Integer> {
	List<City> findByCityNameLike(String cityName);
}
