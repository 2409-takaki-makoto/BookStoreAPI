package com.example.BookStore.application.exception;

import com.example.BookStore.application.exception.error.ErrorObject;

public class BusinessException extends AppException{
	
	public BusinessException(ErrorObject error) {
		super(error);
	}

}
