package com.example.BookStore.application.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.application.api.request.BookRegisterRequest;
import com.example.BookStore.application.api.response.BookRegisterResponse;
import com.example.BookStore.application.api.service.BookService;
import com.example.BookStore.domain.model.Book;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping({"/books", "/books/"})
@RequiredArgsConstructor
public class BookController {

	final private BookService bookService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookRegisterResponse register(@Validated @RequestBody BookRegisterRequest request) {
		
		Book book = request.convertToBook();
		bookService.register(book);
		
		
		return BookRegisterResponse.convertFromBook(book);
	}
}
