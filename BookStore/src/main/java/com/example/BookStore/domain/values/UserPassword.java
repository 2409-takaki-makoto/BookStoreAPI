package com.example.BookStore.domain.values;

public record UserPassword(String value) {
	
	public UserPassword(String value) {
		if (value == null) {
			throw new IllegalArgumentException("ユーザーパスワードの初期化処理に失敗");
		}
		
		this.value = value;
	}

}
