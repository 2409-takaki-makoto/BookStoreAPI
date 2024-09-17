package com.example.BookStore.domain.values;

import java.util.Objects;

public record EmailAddress(String value) {
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (Objects.equals(this, obj)) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof EmailAddress)) {
			return Boolean.FALSE;
		}

		EmailAddress otherObj = (EmailAddress) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}

}
