package com.weather.service.exception;

import static com.weather.service.utill.AppErrorCodes.*;
import static com.weather.service.utill.AppUtills.*;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import feign.FeignException;

@ControllerAdvice
@RestController
public class AppExceptionHandler {

	@ExceptionHandler(FeignException.class)
	public final ResponseEntity<Object> handleFeignExceptions(FeignException ex) {
		if (ex.status() == HttpStatus.NOT_FOUND.value()) {
			return new ResponseEntity<Object>(
					getJsonErrorResponse(NO_DATA_FOUND, "Error occur during web service call \n " + ex.request().url())
							.toString(),
					HttpStatus.NOT_FOUND);
		}
		if (ex.status() == HttpStatus.BAD_REQUEST.value()) {

			return new ResponseEntity<Object>(
					getJsonErrorResponse(BAD_REQUEST, "Error occur during web service call \n " + ex.request().url())
							.toString(),
					HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(GENERAL_FEIGN_ERROR_CODE + "::[cause] " + ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public final ResponseEntity<Object> handleMissingServletRequestParameterException(
			MissingServletRequestParameterException ex) {
		return new ResponseEntity<Object>(
				getJsonErrorResponse(BAD_REQUEST,
						"Error occur during web service call \n [param]:" + ex.getParameterName()).toString(),
				HttpStatus.BAD_REQUEST);
	}

}
