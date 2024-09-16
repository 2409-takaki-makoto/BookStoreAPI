package com.example.BookStore.application.api.service;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.BookStore.application.exception.BusinessException;
import com.example.BookStore.application.exception.error.ErrorObject;
import com.example.BookStore.domain.model.User;
import com.example.BookStore.domain.repository.UserRepository;
import com.example.BookStore.domain.service.user.EmailAddressDuplicationCheckDomainService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;
	@Mock
	private EmailAddressDuplicationCheckDomainService emailExist;

	@Before
	public void init() {
		MockitoAnnotations.openMocks(true);
	}

	@Test
	public void PT001_register() {
		User testUser = new User();

		when(emailExist.execute(Mockito.any())).thenReturn(true);

		try {
			userService.register(testUser);
			
			// 処理が継続した場合はテスト失敗
			fail("例外の発生なし");
		} catch (BusinessException e) {
			assertEquals(ErrorObject.メールアドレスが重複しています, e.getErrorDetail());
		}
	}
	
	@Test
	public void PT002_register() {
		User testUser = new User();

		when(emailExist.execute(Mockito.any())).thenReturn(false);
		doNothing().when(userRepository).register(isA(User.class));
		
		userService.register(testUser);
	}

}
