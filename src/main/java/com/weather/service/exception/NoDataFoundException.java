package com.weather.service.exception;

@SuppressWarnings("serial")
public class NoDataFoundException extends BaseException {

	public NoDataFoundException(String errorCode, String msg) {

		super(errorCode, msg);
	}
}
