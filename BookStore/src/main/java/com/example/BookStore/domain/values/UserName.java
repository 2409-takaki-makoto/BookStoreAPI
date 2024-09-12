package com.example.BookStore.domain.values;

public record UserName(String value) {

	public UserName(String value) {

		if (value == null) {
			throw new IllegalArgumentException("ユーザー名の初期化に失敗");
		}

		this.value = value;
	}

}
