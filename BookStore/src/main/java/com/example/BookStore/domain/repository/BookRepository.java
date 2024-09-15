package com.example.BookStore.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.BookStore.domain.model.Book;
import com.example.BookStore.domain.values.BookId;

@Repository
public interface BookRepository {
	void register(Book book);
	List<Book> getAll();
	Book findById(BookId bookId);
	void update(Book book);
	void delete(BookId bookId);
}
