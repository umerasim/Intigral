package com.weather.service.service;

import org.springframework.stereotype.Service;

@Service
public interface WeatherService {

    public String getWeatherDataByCityOrCountry(String city_country) ;
    public String getWeatherDataByCoordinates(double lat,double lon) ;
    
}
