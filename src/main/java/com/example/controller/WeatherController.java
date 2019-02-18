package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dto.WeatherDTO;
import com.example.entity.City;
import com.example.entity.Weather;
import com.example.form.WeatherForm;
import com.example.service.CityService;
import com.example.service.WeatherService;

@Controller
public class WeatherController {
	private CityService cityService;

	private WeatherService weatherService;

	@Autowired
	public void setCityService(CityService cityService, WeatherService weatherService) {
		this.cityService = cityService;
		this.weatherService = weatherService;
	}

	/**
	 * View a weather by idCity (call api).
	 *
	 * @param idCity
	 * @param model
	 * @return
	 */
	@RequestMapping("weather/{idCity}")
	public String showWeather(@PathVariable Integer idCity, Model model) {
		City city = cityService.getCityById(idCity);
		if (city != null) {
			List<WeatherForm> lst = new ArrayList<WeatherForm>();
			// call api get weather
			WeatherDTO weatherDTO = weatherService.getWeather(city.getCityName());

			if (weatherDTO != null) {
				// Save weather to DB
				Weather weather = new Weather();
				weather.setCountryCode(weatherDTO.getCountryCode());
				weather.setHumidity(weatherDTO.getHumidity());
				weather.setIdCity(idCity);
				weather.setIdWeather(weatherDTO.getWeatherId());
				weather.setNameCity(city.getCityName());
				weather.setPressure(weatherDTO.getPressure());
				weather.setTemperature(weatherDTO.getTemperature());
				weather.setTimeStamp(weatherDTO.getTimeStamp());
				weather.setWeatherIcon(weatherDTO.getWeatherIcon());
				weather.setWeatherMain(weatherDTO.getWeatherMain());
				weatherService.saveWeather(weather);

				// parse weather to weather form using for web
				WeatherForm weatherForm = new WeatherForm(weather);
				lst.add(weatherForm);
				model.addAttribute("weathers", lst);
				model.addAttribute("idCity", idCity);
			} else {
				model.addAttribute("message", "Get weather from api fail!");
			}
		}
		return "cityshowweather";
	}

	/**
	 * View a list weather by idCity.
	 *
	 * @param idCity
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listWeather/{idCity}", method = RequestMethod.GET)
	public String listWeather(@PathVariable Integer idCity, Model model) {
		List<WeatherForm> lstWeatherForm = new ArrayList<WeatherForm>();
		List<Weather> lstWeather = (List<Weather>) weatherService.listAllWeathers(idCity);
		for (Weather weather : lstWeather) {
			lstWeatherForm.add(new WeatherForm(weather));
		}
		model.addAttribute("weathers", lstWeatherForm);

		return "listweather";
	}

	/**
	 * Weather search form.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("weatherForm")
	public String weatherForm(Model model) {
		model.addAttribute("weather", new Weather());
		return "searchweather";
	}

	/**
	 * View a list weather by nameCity.
	 *
	 * @param nameCity
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchWeather", method = RequestMethod.POST)
	public String searchWeather(Weather weatherSearch, Model model) {
		List<WeatherForm> lstWeatherForm = new ArrayList<WeatherForm>();
		List<Weather> lstWeather = (List<Weather>) weatherService.listAllWeathersForWeb(weatherSearch.getNameCity());
		if(lstWeather != null && lstWeather.size() > 0) {
			for (Weather weather : lstWeather) {
				lstWeatherForm.add(new WeatherForm(weather));
			}
			model.addAttribute("weathers", lstWeatherForm);
		}

		return "searchWeather";
	}
}
