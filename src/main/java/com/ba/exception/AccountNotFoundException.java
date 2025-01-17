package com.ba.exception;

public class AccountNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 4650234458298202247L;

	public AccountNotFoundException(String message) {
		super(message);
	}
}
