package com.example.BookStore.application.api.request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.BookStore.domain.model.Order;
import com.example.BookStore.domain.values.BookId;
import com.example.BookStore.domain.values.OrderDate;
import com.example.BookStore.domain.values.OrderQty;
import com.example.BookStore.domain.values.UserId;

import lombok.Data;

@Data
public class OrderRegisterRequest {
	private String userId;
	private Long bookId;
	private Long orderQty;
	private String orderDate;

	final private DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public Order convertToOrder() {
		Order order = new Order();
		order.setUserId(new UserId(this.userId));
		order.setBookId(new BookId(bookId));
		order.setOrderQty(new OrderQty(orderQty));

		if (orderDate == null) {
			// 注文日未設定の場合は現在のシステム日付を設定
			order.setOrderDate(new OrderDate(LocalDateTime.now()));
		} else {
			order.setOrderDate(new OrderDate(LocalDateTime.parse(orderDate, FORMAT)));
		}

		return order;

	}
}
