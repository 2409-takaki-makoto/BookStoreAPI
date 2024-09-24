package com.example.BookStore.domain.values;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record CreatedDate(LocalDateTime value) {

	public CreatedDate {
		if (value == null) {
			throw new IllegalArgumentException("作成日時の初期化処理に失敗");
		}
	}

	public String formatDisplay() {
		return value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (this == obj) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof CreatedDate)) {
			return Boolean.FALSE;
		}

		CreatedDate otherObj = (CreatedDate) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}

}
