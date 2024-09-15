package com.example.BookStore.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.BookStore.domain.model.User;
import com.example.BookStore.domain.model.user.UserSearchCondition;
import com.example.BookStore.domain.values.EmailAddress;
import com.example.BookStore.domain.values.UserId;

@Repository
public interface UserRepository {
	void register(User user);
	boolean emailExists(EmailAddress emailAddress);
	List<User> getAll(UserSearchCondition conditino);
	User findById(UserId userId);
	void update(User user);
}
