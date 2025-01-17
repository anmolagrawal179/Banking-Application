package com.ba.exception;

public class InsufficientBalanceException extends RuntimeException {

	private static final long serialVersionUID = -9185529906444008735L;

	public InsufficientBalanceException(String message) {
		super(message);
	}
}
