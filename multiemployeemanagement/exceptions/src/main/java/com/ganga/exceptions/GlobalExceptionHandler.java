package com.ganga.exceptions;

import java.sql.SQLException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
		String detailedMessage = ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage();
		String shortMessage = parseConstraintViolationMessage(detailedMessage);

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), shortMessage);
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ErrorResponse> handleSQLException(SQLException ex) {
		System.out.println(ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Database error occurred: " + ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Unexpected error: " + ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private String parseConstraintViolationMessage(String message) {
		if (message.contains("Duplicate entry")) {
			return "Duplicate value detected for a unique field.";
		} else if (message.contains("constraint")) {
			return "Constraint violation occurred.";
		}
		return "Data integrity violation.";
	}
}