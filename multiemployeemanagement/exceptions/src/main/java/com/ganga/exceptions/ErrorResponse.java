package com.ganga.exceptions;

public class ErrorResponse {
	private Integer statusCode;
	private String message;
	
	public ErrorResponse(String message) { 
		super();
		this.message= message;
	}
	
	public ErrorResponse(Integer statusCode, String message) {
		this.message = message;
		this.statusCode = statusCode;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorResponse [statusCode=" + statusCode + ", message=" + message + "]";
	}
}
