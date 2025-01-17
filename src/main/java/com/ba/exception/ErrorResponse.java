package com.ba.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {

	private LocalDateTime timestamp;
	private int status;
	private HttpStatus error;
	private String message;
	
}
