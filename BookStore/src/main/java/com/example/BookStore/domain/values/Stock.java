package com.example.BookStore.domain.values;

public record Stock(Long value) {

	public Stock {
		if (value == null) {
			value = 0L;
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

		if (!(obj instanceof Stock)) {
			return Boolean.FALSE;
		}

		Stock otherObj = (Stock) obj;

		return this.value.equals(otherObj.value);
	}
}
