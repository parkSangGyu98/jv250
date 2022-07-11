package com.varxyz.jv250.banking;

public class InsufficientException extends RuntimeException {
	public InsufficientException(String msg) {
		super(msg);
	}
}