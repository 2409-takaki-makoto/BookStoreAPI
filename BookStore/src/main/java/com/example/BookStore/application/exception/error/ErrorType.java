package com.example.BookStore.application.exception.error;

public enum ErrorType {
	SystemError("System"),
	BusinessError("Business"),
	ValidationError("Validation");

	private final String value;
	private ErrorType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
