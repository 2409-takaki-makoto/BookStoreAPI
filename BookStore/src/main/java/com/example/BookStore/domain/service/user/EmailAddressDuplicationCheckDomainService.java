package com.example.BookStore.domain.service.user;

import org.springframework.stereotype.Service;

import com.example.BookStore.domain.repository.UserRepository;
import com.example.BookStore.domain.values.EmailAddress;

import lombok.RequiredArgsConstructor;

/**
 * <p>メールアドレス重複チェック</p>
 * 
 * <dd>メールアドレスが重複していないか確認する。</dd>
 * 
 * @return
 * 	メールアドレスが重複している場合は{@code true}を返却します。
 */
@RequiredArgsConstructor
@Service
public class EmailAddressDuplicationCheckDomainService {
	
	final UserRepository userRepository;
	
	public boolean execute(EmailAddress email) {
		return userRepository.emailExists(email);
	}
}
