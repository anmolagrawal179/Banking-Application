package com.ba.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1401386716708962206L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
