package com.example.BookStore.domain.model;

import java.util.Objects;

import com.example.BookStore.domain.values.BookAuthor;
import com.example.BookStore.domain.values.BookId;
import com.example.BookStore.domain.values.BookTitle;
import com.example.BookStore.domain.values.CreatedDate;
import com.example.BookStore.domain.values.Price;
import com.example.BookStore.domain.values.SalesStatusCode;
import com.example.BookStore.domain.values.Stock;
import com.example.BookStore.domain.values.UpdatedDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {
	private BookId id;
	private BookTitle title;
	private BookAuthor author;
	private Price price;
	private Stock stock;
	private SalesStatusCode salesStatusCode;
	private CreatedDate createdDate;
	private UpdatedDate updatedDate;

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (Objects.equals(this, obj)) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof Book)) {
			return Boolean.FALSE;
		}

		Book otherObj = (Book) obj;

		if (this.id == null) {
			if (otherObj.id == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.id.equals(otherObj.id);
	}
	

}
