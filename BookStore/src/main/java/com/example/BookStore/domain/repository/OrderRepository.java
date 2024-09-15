package com.example.BookStore.domain.repository;

import org.springframework.stereotype.Repository;

import com.example.BookStore.domain.model.Order;

@Repository
public interface OrderRepository {
	void register(Order order);
}
