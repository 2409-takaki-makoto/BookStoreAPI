package com.example.BookStore.application.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookStore.application.exception.BusinessException;
import com.example.BookStore.application.exception.error.ErrorObject;
import com.example.BookStore.domain.model.User;
import com.example.BookStore.domain.model.user.UserSearchCondition;
import com.example.BookStore.domain.repository.UserRepository;
import com.example.BookStore.domain.service.user.EmailAddressDuplicationCheckDomainService;
import com.example.BookStore.domain.values.UserId;

import lombok.RequiredArgsConstructor;

/**
 * ユーザーに関するユースケースを管理するサービスクラス
 */
@Service
@RequiredArgsConstructor
public class UserService {

	final EmailAddressDuplicationCheckDomainService emailAddressDuplicationCheckDomainService;
	
	final UserRepository userRepository;
	
	/**
	 * ユーザーの新規登録を行う
	 * @param user
	 */
	public void register(User user) {
		// メールアドレスの重複をチェックする.
		if (emailAddressDuplicationCheckDomainService.execute(user.getEmailAddress())) {
			throw new BusinessException(ErrorObject.メールアドレスが重複しています);
		}
		
		// ユーザー情報の登録を行う.
		userRepository.register(user);
	}
	
	/**
	 * ユーザーの一覧を取得する
	 * @return
	 */
	public List<User> getList(UserSearchCondition condition) {
		return userRepository.getAll(condition);
	}
	
	/**
	 * IDに紐づくユーザー情報を取得する
	 */
	public User getById(UserId userId) {
		User user = userRepository.findById(userId);
		
		if (user == null) {
			throw new BusinessException(ErrorObject.ユーザー情報がみつかりません);
		}
		
		return user;
	}
	
	/**
	 * ユーザー情報を更新する
	 * 
	 * @param user
	 */
	public void updateUser(User user) {
		
		User checkUser = userRepository.findById(user.getId());
		if (checkUser == null) {
			throw new BusinessException(ErrorObject.ユーザー情報がみつかりません);
		}
		
		userRepository.update(user);
	}
}
