package com.example.BookStore.application.api.errorresponse;

import com.example.BookStore.application.exception.error.ErrorObject;

import lombok.Getter;

@Getter
public class ErrorResponse {
	private String errorType;
	private String errorCode;
	private String errorMessage;

	public ErrorResponse(ErrorObject errorObject) {
		this.errorType = errorObject.getType().getValue();
		this.errorCode = errorObject.getCode();
		this.errorMessage = errorObject.getMessage();
	}

	public ErrorResponse(ErrorObject errorObject, String... embeddedMessage) {
		this(errorObject);
		
		this.errorMessage = errorObject.getMessage(embeddedMessage);
		
	}

}
