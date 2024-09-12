package com.example.BookStore.domain.values;

import java.util.Objects;
import java.util.UUID;

public record UserId(String value) {
	
	public UserId(String value) {
		
		if (value == null) {
			UUID uuid = UUID.randomUUID();
			value = uuid.toString();
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
		
		if (!(obj instanceof UserId)) {
			return Boolean.FALSE;
		}
		
		UserId otherObj = (UserId)obj;
		
		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}
			
			return Boolean.FALSE;
		}
		
		if (this.value.equals(otherObj.value)) {
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}
	
}
