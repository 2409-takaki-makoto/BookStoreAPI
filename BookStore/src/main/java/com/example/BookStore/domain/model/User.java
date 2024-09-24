package com.example.BookStore.domain.model;

import com.example.BookStore.domain.values.CreatedDate;
import com.example.BookStore.domain.values.EmailAddress;
import com.example.BookStore.domain.values.UpdatedDate;
import com.example.BookStore.domain.values.UserId;
import com.example.BookStore.domain.values.UserName;
import com.example.BookStore.domain.values.UserPassword;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private UserId id;
	private UserName name;
	private EmailAddress emailAddress;
	private UserPassword password;
	private CreatedDate createdDate;
	private UpdatedDate updatedDate;

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (this == obj) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof User)) {
			return Boolean.FALSE;
		}

		User otherObj = (User) obj;

		if (this.id == null) {
			if (otherObj.id == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.id.equals(otherObj.id);
	}
}
