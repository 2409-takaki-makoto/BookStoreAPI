package com.example.BookStore.application.api.response;

import java.util.ArrayList;
import java.util.List;

import com.example.BookStore.domain.model.Book;

import lombok.Getter;

@Getter
public class GetBookListResponse {
	private List<BookResponse> books = new ArrayList<>();
	
	public void addBook(BookResponse book) {
		this.books.add(book);
	}
	
	public static GetBookListResponse convertFromBook(List<Book> books) {
		GetBookListResponse response = new GetBookListResponse();
		for (Book book : books) {
			response.addBook(BookResponse.ConvertFromBook(book));
		}
		
		return response;
	}
}
