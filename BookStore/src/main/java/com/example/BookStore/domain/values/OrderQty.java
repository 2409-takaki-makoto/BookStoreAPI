package com.example.BookStore.domain.values;

public record OrderQty(Long value) {

	public OrderQty {
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

		if (!(obj instanceof OrderQty)) {
			return Boolean.FALSE;
		}

		OrderQty otherObj = (OrderQty) obj;

		return this.value.equals(otherObj.value);
	}
}
