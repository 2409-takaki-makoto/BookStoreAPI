package com.example.BookStore.domain.values;

import java.util.Objects;

public record UserPassword(String value) {
	
	public UserPassword(String value) {
		if (value == null) {
			throw new IllegalArgumentException("ユーザーパスワードの初期化処理に失敗");
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

		if (!(obj instanceof UserPassword)) {
			return Boolean.FALSE;
		}

		UserPassword otherObj = (UserPassword) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);

	}

}
