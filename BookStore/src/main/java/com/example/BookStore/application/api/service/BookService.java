package com.example.BookStore.application.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookStore.domain.model.Book;
import com.example.BookStore.domain.repository.BookRepository;
import com.example.BookStore.domain.values.BookId;

import lombok.RequiredArgsConstructor;

/**
 * 書籍に関するユースケースを管理するサービスクラス
 */
@Service
@RequiredArgsConstructor
public class BookService {

	final BookRepository bookRepository;
	
	public void register(Book book) {
		bookRepository.register(book);
	}
	
	public List<Book> getBookList(){
		return bookRepository.getAll();
	}
	
	public Book getBook(BookId bookId) {
		return bookRepository.getBook(bookId);
	}
	
}
