package com.userRecords.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> notFoundExceptionHandler(NotFoundException e,WebRequest request){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST, 
												e.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalExceptionHandler(Exception e,WebRequest request){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST, 
												e.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}

}
