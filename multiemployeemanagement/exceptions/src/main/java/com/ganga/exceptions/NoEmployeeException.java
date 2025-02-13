package com.ganga.exceptions;

public class NoEmployeeException extends RuntimeException {
	private String message;
	public NoEmployeeException() {
		
	}
	
	public NoEmployeeException(String message) { 
		super(message);
		this.message = message;
	}
}
