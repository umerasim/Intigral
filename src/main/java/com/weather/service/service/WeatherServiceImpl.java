package com.weather.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.weather.service.client.WeatherClient;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherClient weatherClient;

	@Override
	@Cacheable(cacheNames = "getWeatherDataByCityOrCountry", key = "#city_country")
	public String getWeatherDataByCityOrCountry(String city_country) {
		ResponseEntity<String> response = weatherClient.searchWeatherByCityORCountry(city_country);
		if (response.getStatusCode() == HttpStatus.OK)
			return response.getBody();
		return null;

	}

	@Override
	@Cacheable(cacheNames = "getWeatherDataByCoordinates", key = "#lat" + "-" + "#lon")
	public String getWeatherDataByCoordinates(double lat, double lon) {
		ResponseEntity<String> response = weatherClient.searchWeatherByCoordinates(lat, lon);
		if (response.getStatusCode() == HttpStatus.OK)
			return response.getBody();
		return null;
	}

}
