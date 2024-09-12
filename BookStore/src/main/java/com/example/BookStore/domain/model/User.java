package com.example.BookStore.domain.model;

import com.example.BookStore.domain.values.CreatedDate;
import com.example.BookStore.domain.values.EmailAddress;
import com.example.BookStore.domain.values.UpdatedDate;
import com.example.BookStore.domain.values.UserId;
import com.example.BookStore.domain.values.UserName;
import com.example.BookStore.domain.values.UserPassword;

import lombok.Data;

@Data
public class User {
	private UserId id;
	private UserName name;
	private EmailAddress emailAddress;
	private UserPassword password;
	private CreatedDate createdDate;
	private UpdatedDate updatedDate;

}
