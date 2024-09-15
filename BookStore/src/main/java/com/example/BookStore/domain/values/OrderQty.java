package com.example.BookStore.domain.values;

import java.util.Objects;

public record OrderQty(Long value) {

	public OrderQty(Long value) {
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

		if (!(obj instanceof OrderQty)) {
			return Boolean.FALSE;
		}

		OrderQty otherObj = (OrderQty) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}
}
