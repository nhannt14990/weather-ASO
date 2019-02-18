package com.example.service;

import com.example.dto.WeatherDTO;
import com.example.entity.Weather;

public interface WeatherService {
	Iterable<Weather> listAllWeathers(String cityName);
	
	Iterable<Weather> listAllWeathersForWeb(String cityName);
	
	Iterable<Weather> listAllWeathers(Integer idCity);
	
	Iterable<Weather> listAllWeathers();
    
    Weather saveWeather(Weather weather);

    WeatherDTO getWeather(String city);

}
