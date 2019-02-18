package com.example.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nameCity;

	private long timeStamp;

	private double temperature;
	
	private double humidity;
	
	private double pressure;

	private Integer weatherId;

	private String weatherIcon;

	private String weatherMain;

	private String countryCode;

	@JsonProperty("name")
	public String getNameCity() {
		return this.nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	@JsonProperty("timestamp")
	public long getTimeStamp() {
		return this.timeStamp;
	}

	@JsonSetter("dt")
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(double temperatureKelvin) {
		this.temperature = temperatureKelvin;
	}

	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		double temp = Double.parseDouble(main.get("temp").toString());
		setTemperature(temp);
		double hum = Double.parseDouble(main.get("humidity").toString());
		setHumidity(hum);
		double pre = Double.parseDouble(main.get("pressure").toString());
		setPressure(pre);
	}

	public Integer getWeatherId() {
		return this.weatherId;
	}

	public void setWeatherId(Integer weatherId) {
		this.weatherId = weatherId;
	}

	public String getWeatherIcon() {
		return this.weatherIcon;
	}

	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}

	public String getWeatherMain() {
		return weatherMain;
	}

	public void setWeatherMain(String weatherMain) {
		this.weatherMain = weatherMain;
	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherId((Integer) weather.get("id"));
		setWeatherIcon((String) weather.get("icon"));
		setWeatherMain((String) weather.get("main"));
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@JsonProperty("sys")
	public void setSys(Map<String, Object> sys) {
		setCountryCode((String) sys.get("country"));
	}

}
