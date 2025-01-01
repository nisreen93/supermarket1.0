package com.supermarket.exception.handler.global;

public class NotFoundException extends RuntimeException {
	public NotFoundException(String message) {
		super(message);
	}
}