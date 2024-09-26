package com.example.BookStore.domain.values;

public record EmailAddress(String value) {
	
	public EmailAddress {
		if (value == null) {
			throw new IllegalArgumentException("ユーザーのメールアドレスの初期化に失敗");
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

		if (!(obj instanceof EmailAddress)) {
			return Boolean.FALSE;
		}

		EmailAddress otherObj = (EmailAddress) obj;
		return this.value.equals(otherObj.value);
	}

}
