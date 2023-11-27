package com.example.practica.exception;

public class RequestException extends RuntimeException{

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public RequestException(String code, String message) {
		super(message);
		this.code = code;
	}
}
