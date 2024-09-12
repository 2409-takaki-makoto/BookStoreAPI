package com.example.BookStore.application.api.request;

import jakarta.validation.constraints.Size;

import com.example.BookStore.application.api.customvalidation.ValidGroup1;
import com.example.BookStore.application.api.customvalidation.ValidGroup2;
import com.example.BookStore.application.api.customvalidation.notblank.NotBlank;
import com.example.BookStore.domain.model.User;
import com.example.BookStore.domain.values.EmailAddress;
import com.example.BookStore.domain.values.UserId;
import com.example.BookStore.domain.values.UserName;
import com.example.BookStore.domain.values.UserPassword;

import lombok.Data;

@Data
public class SignUpUserRequest {

	@NotBlank(groups = ValidGroup1.class, message = "ユーザー名を入力してください。")
	@Size(groups = ValidGroup2.class, min = 3, max = 20, message = "名前は{min}文字以上{max}文字以下で入力してください。")
	private String name;

	@NotBlank(groups = ValidGroup1.class, message = "メールアドレスを入力してください。")
	@Size(groups = ValidGroup2.class, min = 4, max = 255, message = "メールアドレスは{min}文字以上{max}文字以下で入力してください。")
	private String emailAddress;

	@NotBlank(groups = ValidGroup1.class, message = "パスワードを入力してください。")
	@Size(groups = ValidGroup2.class, min = 6, max = 255, message = "パスワードは{min}文字以上{max}文字以下で入力してください。")
	private String password;

	public User convertToDomain() {
		User user = new User();
		user.setId(new UserId(null));
		user.setName(new UserName(this.name));
		user.setEmailAddress(new EmailAddress(this.emailAddress));
		user.setPassword(new UserPassword(this.password));

		return user;
	}

}
