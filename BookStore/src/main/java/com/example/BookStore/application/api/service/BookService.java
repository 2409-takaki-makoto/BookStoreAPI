package com.example.BookStore.application.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookStore.application.exception.BusinessException;
import com.example.BookStore.application.exception.error.ErrorObject;
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
	
	/**
	 * 書籍新規登録
	 * @param book
	 */
	public void register(Book book) {
		bookRepository.register(book);
	}
	
	/**
	 * 書籍一覧取得
	 * @return
	 */
	public List<Book> getAll(){
		return bookRepository.getAll();
	}
	
	public Book getBook(BookId bookId) {
		Book book = bookRepository.findById(bookId);
		
		if (book == null) {
			throw new BusinessException(ErrorObject.書籍情報が見つかりません);
		}
		
		return book;
	}
	
	public void update(Book book) {
		// 書籍情報の取得
		Book beforeBook = bookRepository.findById(book.getId());
		
		if (beforeBook == null) {
			throw new BusinessException(ErrorObject.書籍情報が見つかりません);
		}
		
		// 更新
		bookRepository.update(book);
		
	}
	
	public void delete(BookId bookId) {
		// 書籍情報の取得
		Book book = bookRepository.findById(bookId);
		if (book == null) {
			throw new BusinessException(ErrorObject.書籍情報が見つかりません);
		}
		
		bookRepository.delete(bookId);
	}
	
}
