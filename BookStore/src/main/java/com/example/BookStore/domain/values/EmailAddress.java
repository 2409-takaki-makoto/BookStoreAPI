package com.example.BookStore.domain.values;

public record EmailAddress(String value) {
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}

}
