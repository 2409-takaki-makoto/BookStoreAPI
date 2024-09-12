package com.example.BookStore.application.exception;

import com.example.BookStore.application.exception.error.ErrorObject;

import lombok.Getter;

@Getter
public class SystemException extends AppException {

	public SystemException(ErrorObject error) {
		super(error);
	}
}
