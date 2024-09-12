package com.example.BookStore.application.exception;

import com.example.BookStore.application.exception.error.ErrorObject;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException{
	ErrorObject errorDetail;
	String[] embedded;
	
	public AppException(ErrorObject error) {
		super(error.getMessage());
		this.errorDetail = error;
	}
	
	public AppException(ErrorObject error, String... embeddedMessage) {
		this(error);
		this.embedded = embeddedMessage;
	}
	
	@Override
	public String getMessage() {
		return this.errorDetail.getMessage(this.embedded);
	}
}
