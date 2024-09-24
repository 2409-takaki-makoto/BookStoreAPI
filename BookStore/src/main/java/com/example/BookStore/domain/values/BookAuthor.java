package com.example.BookStore.domain.values;

public record BookAuthor(String value) {
	
	public BookAuthor {
		if (value == null) {
			throw new IllegalArgumentException("書籍の著者の初期化に失敗");
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (this == obj) {
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
