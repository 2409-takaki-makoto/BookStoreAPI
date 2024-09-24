package com.example.BookStore.domain.values;

public record BookId(Long value) {

	public BookId {
		if (value == null) {
			throw new IllegalArgumentException("書籍IDの初期化に失敗");
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

		if (!(obj instanceof BookId)) {
			return Boolean.FALSE;
		}

		BookId otherObj = (BookId) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);

	}
}
