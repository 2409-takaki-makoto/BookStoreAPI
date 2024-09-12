package com.example.BookStore.application.api.errorresponse;

import lombok.Getter;

@Getter
public class ValidationErrorDetail {
	private String field;
	private String errorMessage;
	
	public ValidationErrorDetail(String field, String errorMessage) {
		this.field = field;
		this.errorMessage = errorMessage;
	}

}
