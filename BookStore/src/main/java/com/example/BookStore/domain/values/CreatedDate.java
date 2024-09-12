package com.example.BookStore.domain.values;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record CreatedDate(LocalDateTime value) {
	
	public CreatedDate(LocalDateTime value) {
		if (value == null) {
			throw new IllegalArgumentException("作成日時の初期化処理に失敗");
		}
		
		this.value = value;
	}
	
	public String formatDisplay() {
		return value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

}
