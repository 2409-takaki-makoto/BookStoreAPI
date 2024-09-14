package com.example.BookStore.application.api.response;

import com.example.BookStore.domain.model.Book;

import lombok.Data;

@Data
public class BookRegisterResponse {
	private long id;
	private String title;
	private String author;
	private long price;
	private long stock;
	private String salesStatusCode;
	
	public static BookRegisterResponse convertFromBook(Book book) {
		BookRegisterResponse response = new BookRegisterResponse();
		response.setId(book.getId().value());
		response.setTitle(book.getTitle().value());
		response.setAuthor(book.getAuthor().value());
		response.setPrice(book.getPrice().value());
		response.setStock(book.getStock().value());
		response.setSalesStatusCode(book.getSalesStatusCode().value());
		
		return response;
	}
}
