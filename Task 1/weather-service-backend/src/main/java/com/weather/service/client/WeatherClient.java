package com.weather.service.client;

import static com.weather.service.utill.AppConstants.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weather", url = WEATHER_SEARCH_BY_CITY_COUNTRY_BASE_URL)
public interface WeatherClient {

	@GetMapping(SEARCH_BY_CITY_COUNTRY)
	public ResponseEntity<String> searchWeatherByCityORCountry(@RequestParam String q);

	@GetMapping(SEARCH_BY_COORDINATES)
	public ResponseEntity<String> searchWeatherByCoordinates(@RequestParam double lat, @RequestParam double lon);

}
