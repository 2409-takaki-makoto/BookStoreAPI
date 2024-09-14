package com.example.BookStore.application.api.request;

import com.example.BookStore.domain.values.BookId;

public record BookIdDto(
		String value
		) {
	
	public BookId convertToDomain() {
		return new BookId(Long.parseLong(value));
	}
	
	public static BookIdDto valueOf(String value) {
		BookIdDto dto = new BookIdDto(value);
		
		return dto;
		
	}
}
