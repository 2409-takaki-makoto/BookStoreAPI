package com.example.BookStore.application.api.service;

import org.springframework.stereotype.Service;

import com.example.BookStore.application.exception.BusinessException;
import com.example.BookStore.application.exception.error.ErrorObject;
import com.example.BookStore.domain.model.Book;
import com.example.BookStore.domain.model.Order;
import com.example.BookStore.domain.model.User;
import com.example.BookStore.domain.repository.BookRepository;
import com.example.BookStore.domain.repository.OrderRepository;
import com.example.BookStore.domain.repository.UserRepository;
import com.example.BookStore.domain.values.OrderStatusCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	final private UserRepository userRepository;
	final private BookRepository bookRepository;
	final private OrderRepository orderRepository;
	
	
	public Order register(Order order) {
		
		// ユーザーの存在チェック
		User user = userRepository.findById(order.getUserId());
		if (user == null) {
			throw new BusinessException(ErrorObject.ユーザー情報がみつかりません);
		}
		
		// 書籍情報の取得
		Book book = bookRepository.findById(order.getBookId());
		
		// 書籍情報の存在チェック
		if (book == null) {
			throw new BusinessException(ErrorObject.書籍情報が見つかりません);
		}
		
		// 注文ステータスが未設定の場合は、初期値で設定する
		if (order.getOrderStatusCode() == null) {
			order.setOrderStatusCode(OrderStatusCode.AWAIT_PAYMENT);
		}
		
		// 注文の料金明細情報の作成
		order.calculateOrderDetailForPrice(book);
		
		// 登録する
		orderRepository.register(order);
		
		return order;
	}
}
