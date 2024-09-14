package com.example.BookStore.application.api.response;

import java.time.LocalDateTime;

import com.example.BookStore.domain.model.Book;

import lombok.Data;

@Data
public class BookResponse {
	private Long id;
	private String title;
	private String author;
	private Long price;
	private Long stock;
	private String salesStatusCode;
	private LocalDateTime createdDate;
	
	public static BookResponse ConvertFromBook(Book book) {
		BookResponse bookObj = new BookResponse();
		bookObj.setId(book.getId().value());
		bookObj.setTitle(book.getTitle().value());
		bookObj.setAuthor(book.getAuthor().value());
		bookObj.setPrice(book.getPrice().value());
		bookObj.setStock(book.getStock().value());
		bookObj.setSalesStatusCode(book.getSalesStatusCode().value());
		bookObj.setCreatedDate(book.getCreatedDate().value());
		
		return bookObj;
	}
}
