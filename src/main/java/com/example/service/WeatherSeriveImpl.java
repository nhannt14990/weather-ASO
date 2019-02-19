package com.example.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.example.dto.WeatherDTO;
import com.example.entity.Weather;
import com.example.repositories.WeatherRepository;

@Service
public class WeatherSeriveImpl implements WeatherService{
	private WeatherRepository weatherRepository;

	@Value("${apikey}")
	private String apiKey;


	@Autowired
	public void setWeatherRepository(WeatherRepository weatherRepository) {
		this.weatherRepository = weatherRepository;
	}
	@Override
	public Iterable<Weather> listAllWeathers(String cityName) {
		return weatherRepository.findByNameCity(cityName);
	}

	@Override
	public Weather saveWeather(Weather weather) {
		return weatherRepository.save(weather);
	}
	
	@Override
	public WeatherDTO getWeather(String city) {
		WeatherDTO weatherdto = null;

		if (validParameters(city, apiKey)) {
			String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=" + this.apiKey;
			URI url = new UriTemplate(apiUrl).expand(city, apiKey);

			weatherdto = invoke(url, WeatherDTO.class);
		}
		return weatherdto;

	}
	
	private boolean validParameters(String city, String apiKey) {
		return city != null && !"".equals(city) && apiKey != null && !"".equals(apiKey);
	}

	private <T> T invoke(URI url, Class<T> responseType) {
		T weatherDTO = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
			ResponseEntity<T> exchange = restTemplate.exchange(request, responseType);
			weatherDTO = exchange.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return weatherDTO;
	}
	@Override
	public Iterable<Weather> listAllWeathers(Integer idCity) {
		return weatherRepository.findByIdCity(idCity);
	}
	@Override
	public Iterable<Weather> listAllWeathersForWeb(String cityName) {
		return weatherRepository.findByNameCityForWeb(cityName);
	}
	@Override
	public Iterable<Weather> listAllWeathers() {
		return weatherRepository.findAll();
	}
	@Override
	public void deleteWeather(Weather weather) {
		weatherRepository.delete(weather);
		
	}

}
