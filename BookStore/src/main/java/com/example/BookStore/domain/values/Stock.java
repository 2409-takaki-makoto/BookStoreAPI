package com.example.BookStore.domain.values;

import java.util.Objects;

public record Stock(Long value) {

	public Stock(Long value) {
		if (value == null) {
			value = 0L;
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

		if (!(obj instanceof Stock)) {
			return Boolean.FALSE;
		}

		Stock otherObj = (Stock) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}
}
