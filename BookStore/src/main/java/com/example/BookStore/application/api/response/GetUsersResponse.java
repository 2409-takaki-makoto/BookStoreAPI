package com.example.BookStore.application.api.response;

import java.util.ArrayList;
import java.util.List;

import com.example.BookStore.domain.model.User;

import lombok.Data;

@Data
public class GetUsersResponse {
	List<UserResponse> users = new ArrayList<>();
	
	public void addUser(UserResponse user) {
		users.add(user);
	}
	
	public static GetUsersResponse convertFromDomain(List<User> users) {
		
		GetUsersResponse usersObj = new GetUsersResponse();
		
		for (User user : users) {
			usersObj.addUser(UserResponse.convertFromDomain(user));
		}
		
		return usersObj;
		
	}

}
