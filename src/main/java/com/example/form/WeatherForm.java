package com.example.form;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.example.entity.Weather;

public class WeatherForm {
	private String nameCity;

	private String weatherIcon;

	private String temperature;

	private String weatherMain;

	private String countryCode;

	private String timeStamp;

	public WeatherForm(Weather weather) {
		this.nameCity = weather.getNameCity();
		this.weatherIcon = weather.getWeatherIcon();
		double temperatureCelsius = kelvinToCelsius(weather.getTemperature());
		this.temperature = getTemperatureDigitFormatting(temperatureCelsius);
		this.weatherMain = weather.getWeatherMain();
		this.countryCode = weather.getCountryCode();
		this.timeStamp = getFormattedDateTime(getTimeInInstantFormat(weather.getTimeStamp()),"yyyy.MM.dd HH:mm");
	}

	public String getNameCity() {
		return this.nameCity;
	}

	public String getWeatherIcon() {
		return this.weatherIcon;
	}

	public String getTemperature() {
		return this.temperature;
	}

	public String getWeatherMain() {
		return weatherMain;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public String getTimeStamp() {
		return this.timeStamp;
	}

	protected String getFormattedDateTime(Instant timeStamp, String pattern) {
		String formattedString = "";
		if(timeStamp!=null && pattern!=null && !"".equals(pattern)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			LocalDateTime ldt = LocalDateTime.ofInstant(timeStamp, ZoneId.systemDefault());
			formattedString = ldt.format(formatter);
		}
		return formattedString;
	}

	protected double celsiusToFahrenheit(double temperature) {
		return  (temperature * 9/5.0) +32;
	}

	protected Instant getTimeInInstantFormat(long sunriseTimestamp) {
		return Instant.ofEpochMilli(sunriseTimestamp * 1000);
	}

	protected double kelvinToCelsius(double temperatureKelvin) {
		return temperatureKelvin - 273.0;
	}

	protected String getTemperatureDigitFormatting(double temperature) {
		return String.format("%4.2f", temperature);
	}

}

