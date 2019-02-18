package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weather")
public class Weather {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Integer id;

	@Column(name = "IdCity")
	private Integer idCity;

	@Column(name = "NameCity")
	private String nameCity;

	@Column(name = "IdWeather")
	private Integer idWeather;

	@Column(name = "TimeStamp")
	private long timeStamp;

	@Column(name = "Temperature")
	private Double temperature;

	@Column(name = "Humidity")
	private Double humidity;

	@Column(name = "Pressure")
	private Double pressure;

	@Column(name = "WeatherMain")
	private String weatherMain;

	@Column(name = "WeatherIcon")
	private String weatherIcon;

	@Column(name = "CountryCode")
	private String countryCode;

	public Weather() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdWeather() {
		return idWeather;
	}

	public void setIdWeather(Integer idWeather) {
		this.idWeather = idWeather;
	}

	public Integer getIdCity() {
		return idCity;
	}

	public void setIdCity(Integer idCity) {
		this.idCity = idCity;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public String getWeatherMain() {
		return weatherMain;
	}

	public void setWeatherMain(String weatherMain) {
		this.weatherMain = weatherMain;
	}

	public String getWeatherIcon() {
		return weatherIcon;
	}

	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
