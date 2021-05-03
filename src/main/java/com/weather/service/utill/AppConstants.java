package com.weather.service.utill;

public class AppConstants {

	public static final String WEATHER_SEARCH_BY_CITY_COUNTRY_BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
	private static final String CITY_COUNTRY_PARAM = "?q=";
	private static final String APP_KEY = "ffa6f13ea40a22452bba3be726315d3f";
	private static final String APP_ID_PARAM = "&appid=" + APP_KEY;
	private static final String LAT_PARAM = "?lat=";
	private static final String LON_PARAM = "&lon=";

	public static final String SEARCH_BY_CITY_COUNTRY = CITY_COUNTRY_PARAM + APP_ID_PARAM;
	public static final String SEARCH_BY_COORDINATES = LAT_PARAM + LON_PARAM + APP_ID_PARAM;

	public static final String BASE_PACKAGE = "com.weather.service";

}
