package com.example.BookStore.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.BookStore.domain.model.Book;

@Repository
public interface BookRepository {
	void register(Book book);
	List<Book> getAll();
}
