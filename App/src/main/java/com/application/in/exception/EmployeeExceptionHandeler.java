package com.application.in.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.application.in.Response.Response;

@ControllerAdvice
public class EmployeeExceptionHandeler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(String message) {
		Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<Response> handleUserException(EmployeeException userException) {
		Response response = new Response(HttpStatus.BAD_REQUEST.value(), userException.getMessage());
		return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	}

	
	
	

	
}