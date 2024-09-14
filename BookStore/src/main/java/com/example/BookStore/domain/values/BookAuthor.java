package com.example.BookStore.domain.values;

import java.util.Objects;

public record BookAuthor(String value) {
	
	public BookAuthor(String value) {
		if (value == null) {
			throw new IllegalArgumentException("書籍の著者の初期化に失敗");
		}
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (Objects.equals(this, obj)) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof BookAuthor)) {
			return Boolean.FALSE;
		}

		BookAuthor otherObj = (BookAuthor) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}
}
