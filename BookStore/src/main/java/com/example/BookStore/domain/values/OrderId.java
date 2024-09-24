package com.example.BookStore.domain.values;

public record OrderId(Long value) {

	public OrderId {
		if (value == null) {
			throw new IllegalArgumentException("注文IDの初期化に失敗");
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

		if (!(obj instanceof OrderId)) {
			return Boolean.FALSE;
		}

		OrderId otherObj = (OrderId) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);

	}
}
