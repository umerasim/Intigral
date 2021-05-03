package com.weather.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.service.exception.NoDataFoundException;
import com.weather.service.service.WeatherService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	Logger logger = LoggerFactory.getLogger(WeatherController.class);

	/****
	 * 
	 * 
	 * @param city_country city name and country code divided by comma, use ISO 3166
	 *                     country codes
	 * @return
	 * @throws NoDataFoundException
	 */
	@GetMapping("searchByPlace")
	public ResponseEntity<String> searchByPlace(
			@ApiParam(value = "city name and country code divided by comma, use ISO 3166 country codes") @RequestParam String city_country)
			throws NoDataFoundException {
		logger.info("---------WeatherController: /api/search Web Service Call Start with param " + city_country);
		String response = weatherService.getWeatherDataByCityOrCountry(city_country);
		logger.info("---------WeatherController: /api/search Web Service Call End with response " + response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/**
	 * 
	 * @param lat
	 * @param lon
	 * @return
	 * @throws NoDataFoundException
	 */
	@GetMapping("searchByCoordinates")
	public ResponseEntity<String> searchByCoordinates(@RequestParam double lat, @RequestParam double lon)
			throws NoDataFoundException {
		logger.info("---------WeatherController: /api/searchByCoordinates Web Service Call Start with param lat:" + lat
				+ "\n lon:" + lon);
		String response = weatherService.getWeatherDataByCoordinates(lat, lon);
		logger.info(
				"---------WeatherController: /api/searchByCoordinates Web Service Call End with response " + response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
