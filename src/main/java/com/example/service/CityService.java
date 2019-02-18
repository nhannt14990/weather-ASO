package com.example.service;

import com.example.entity.City;

public interface CityService {

    Iterable<City> listAllCities();
    
    Iterable<City> search(String cityName);

    City getCityById(Integer id);

    City saveCity(City city);

    void deleteCity(Integer idCity);

}
