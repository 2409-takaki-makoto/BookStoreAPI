package com.example.BookStore.domain.values;

public record UserPassword(String value) {

	public UserPassword {
		if (value == null) {
			throw new IllegalArgumentException("ユーザーパスワードの初期化処理に失敗");
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

		if (!(obj instanceof UserPassword)) {
			return Boolean.FALSE;
		}

		UserPassword otherObj = (UserPassword) obj;

		return this.value.equals(otherObj.value);

	}

}
