package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.City;
import com.example.repositories.CityRepository;

/**
 * City service implement.
 */
@Service
public class CityServiceImpl implements CityService {

	private CityRepository cityRepository;

	@Autowired
	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public Iterable<City> listAllCities() {
		return cityRepository.findAll();
	}

	@Override
	public City getCityById(Integer id) {
		return cityRepository.findOne(id);
	}

	@Override
	public City saveCity(City city) {
		return cityRepository.save(city);
	}

	@Override
	public void deleteCity(Integer idCity) {
		cityRepository.delete(idCity);
	}

	@Override
	public Iterable<City> search(String cityName) {
		return cityRepository.findByCityNameLike(cityName);
	}

}
