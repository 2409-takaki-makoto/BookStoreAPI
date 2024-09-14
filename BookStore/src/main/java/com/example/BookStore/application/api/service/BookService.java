package com.example.BookStore.application.api.service;

import org.springframework.stereotype.Service;

import com.example.BookStore.domain.model.Book;
import com.example.BookStore.domain.repository.BookRepository;

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
	
}
