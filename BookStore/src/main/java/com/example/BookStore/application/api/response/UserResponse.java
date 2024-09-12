package com.example.BookStore.application.api.response;

import com.example.BookStore.domain.model.User;

import lombok.Data;

@Data
public class UserResponse {
	private String id;
	private String name;
	private String emailAddress;
	private String createdDate;
	
	public static UserResponse convertFromDomain(User user) {
		
		UserResponse userObj = new UserResponse();
		
		userObj.setId(user.getId().value());
		userObj.setName(user.getName().value());
		userObj.setEmailAddress(user.getEmailAddress().value());
		userObj.setCreatedDate(user.getCreatedDate().formatDisplay());
		
		return userObj;
	}

}
