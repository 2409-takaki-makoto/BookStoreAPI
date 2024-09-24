package com.example.BookStore.domain.values;

public record UnitCost(Long value) implements IPrice {

	public UnitCost {
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

		if (!(obj instanceof UnitCost)) {
			return Boolean.FALSE;
		}

		UnitCost otherObj = (UnitCost) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}
}
