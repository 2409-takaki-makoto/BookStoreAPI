package com.example.BookStore.application.api.response;

import com.example.BookStore.domain.model.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpUserResponse {
	private String id;
	private String name;
	private String emailAddress;
	
	public static SignUpUserResponse convertFromDomain(User user) {
		return SignUpUserResponse.builder()
				
				.id(user.getId().value())
				.name(user.getName().value())
				.emailAddress(user.getEmailAddress().value())
				
				.build();
	}

}
