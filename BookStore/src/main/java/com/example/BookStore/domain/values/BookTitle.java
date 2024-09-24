package com.example.BookStore.domain.values;

public record BookTitle(String value) {

	public BookTitle {
		if (value == null) {
			throw new IllegalArgumentException("書籍タイトルの初期化に失敗");
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

		if (!(obj instanceof BookTitle)) {
			return Boolean.FALSE;
		}

		BookTitle otherObj = (BookTitle) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}
}
