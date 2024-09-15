package com.example.BookStore.application.api.request;

import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.example.BookStore.application.api.customvalidation.notblank.NotBlank;
import com.example.BookStore.application.api.customvalidation.salesstatuscodecheck.SalesStatusCodeCheck;
import com.example.BookStore.domain.model.Book;
import com.example.BookStore.domain.values.BookAuthor;
import com.example.BookStore.domain.values.BookTitle;
import com.example.BookStore.domain.values.SalesStatusCode;
import com.example.BookStore.domain.values.Stock;
import com.example.BookStore.domain.values.UnitCost;

import lombok.Data;

@Data
public class BookRegisterRequest {
	@NotBlank(message = "タイトルを入力してください")
	@Size(min = 1, max = 50, message = "タイトルは{min}以上{max}以下で入力してください")
	private String title;
	
	@NotBlank(message = "著者を入力してください")
	@Size(min = 1, max = 30, message = "著者は{min}以上{max}以下で入力してください")
	private String author;
	
	@Range(min = 0, max = 1_000_000, message = "有効範囲外です({min} - {max})")
	private Long price;
	
	@Range(min = 0, max = 1_000_000, message = "有効範囲外です({min} - {max})")
	private Long stock;
	
	@SalesStatusCodeCheck
	private String salesStatusCode;
	
	public Book convertToBook() {
		Book book = new Book();
		book.setTitle(new BookTitle(title));
		book.setAuthor(new BookAuthor(author));
		book.setPrice(new UnitCost(price));
		book.setStock(new Stock(stock));
		book.setSalesStatusCode(new SalesStatusCode(salesStatusCode));
		
		return book;
		
	}
}
