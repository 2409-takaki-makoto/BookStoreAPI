package com.example.BookStore.application.api.errorresponse;

import static com.example.BookStore.application.exception.error.ErrorType.*;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ValidationErrorResponse {
	private String errorType = ValidationError.getValue();
	private List<ValidationErrorDetail> errors = new ArrayList<>();
	
	public void add(ValidationErrorDetail error) {
		errors.add(error);
	}
}
