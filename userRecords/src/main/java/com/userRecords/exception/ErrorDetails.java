package com.userRecords.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
	private final LocalDateTime timestamp;
	private final HttpStatus httpStatus;
	private final String message;
	private final String details;
	public ErrorDetails(LocalDateTime timestamp, HttpStatus httpStatus, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.httpStatus = httpStatus;
		this.message = message;
		this.details = details;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
}
