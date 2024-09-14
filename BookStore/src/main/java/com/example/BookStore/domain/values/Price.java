package com.example.BookStore.domain.values;

import java.util.Objects;

public record Price(Long value) {

	public Price(Long value) {
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

		if (!(obj instanceof Price)) {
			return Boolean.FALSE;
		}

		Price otherObj = (Price) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}
}
