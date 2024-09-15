package com.example.BookStore.application.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.application.api.customvalidation.GroupOrder;
import com.example.BookStore.application.api.request.GetUsersRequest;
import com.example.BookStore.application.api.request.SignUpUserRequest;
import com.example.BookStore.application.api.response.GetUsersResponse;
import com.example.BookStore.application.api.response.SignUpUserResponse;
import com.example.BookStore.application.api.response.UserResponse;
import com.example.BookStore.application.api.service.UserService;
import com.example.BookStore.domain.model.User;
import com.example.BookStore.domain.model.user.UserSearchCondition;
import com.example.BookStore.domain.values.UserId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping({"/users/", "/users"})
public class UserController {
	private final UserService userService;
	
	/**
	 * ユーザーの新規登録を行う。
	 * 
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SignUpUserResponse signUp(@Validated(GroupOrder.class) @RequestBody SignUpUserRequest request) {
		
		User user = request.convertToDomain();
		
		userService.register(user);
		
		SignUpUserResponse response = SignUpUserResponse.convertFromDomain(user);
		return response;
	}
	
	/**
	 * ユーザーの一覧を取得する。
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public GetUsersResponse getUserList(@Validated @RequestBody GetUsersRequest request) {
		
		
		UserSearchCondition condition = request.convertToDomain();
		List<User> users = userService.getList(condition);
		
		
		return GetUsersResponse.convertFromDomain(users);
		
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserResponse getUser(@PathVariable("id") UserId userId) {
		
		User user = userService.getById(userId);
		
		
		return UserResponse.convertFromDomain(user);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateUser(@PathVariable("id") UserId userId, @Validated @RequestBody SignUpUserRequest request) {
		User user = request.convertToDomain();
		user.setId(userId);
		
		userService.updateUser(user);
	}
}
