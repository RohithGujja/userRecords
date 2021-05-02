package com.userRecords.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public String notFoundExceptionHandler(NotFoundException e, WebRequest request, Model model){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST, 
												e.getMessage(), request.getDescription(false));
		model.addAttribute("error", error);
		return "errorPage";
	}
	
	@ExceptionHandler(Exception.class)
	public String globalExceptionHandler(Exception e, WebRequest request, Model model){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST, 
												e.getMessage(), request.getDescription(false));
		model.addAttribute("error", error);
		return "errorPage";
	}

}
