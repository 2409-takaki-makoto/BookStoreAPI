package com.example.BookStore.domain.values;

public record UserName(String value) {

	public UserName {
		if (value == null) {
			throw new IllegalArgumentException("ユーザー名の初期化に失敗");
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

		if (!(obj instanceof UserName)) {
			return Boolean.FALSE;
		}

		UserName otherObj = (UserName) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);

	}

}
