package com.example.BookStore.domain.values;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record UpdatedDate(LocalDateTime value) {

	public UpdatedDate {
		if (value == null) {
			throw new IllegalArgumentException("更新日時の初期化処理に失敗");
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

		if (!(obj instanceof UpdatedDate)) {
			return Boolean.FALSE;
		}

		UpdatedDate otherObj = (UpdatedDate) obj;

		return this.value.equals(otherObj.value);

	}

}
