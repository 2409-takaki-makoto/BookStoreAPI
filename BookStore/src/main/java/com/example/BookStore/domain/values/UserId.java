package com.example.BookStore.domain.values;

import java.util.UUID;

public record UserId(String value) {

	public UserId {
		if (value == null) {
			UUID uuid = UUID.randomUUID();
			value = uuid.toString();
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

		if (!(obj instanceof UserId)) {
			return Boolean.FALSE;
		}

		UserId otherObj = (UserId) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);

	}

}
