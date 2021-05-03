package com.weather.service.exception;

public class BaseException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String msg;

	public BaseException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
