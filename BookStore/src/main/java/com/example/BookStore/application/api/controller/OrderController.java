package com.example.BookStore.application.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.application.api.request.OrderRegisterRequest;
import com.example.BookStore.application.api.response.OrderRegisterResponse;
import com.example.BookStore.application.api.service.OrderService;
import com.example.BookStore.domain.model.Order;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping({ "/orders", "/orders/" })
@RequiredArgsConstructor
public class OrderController {

	final private OrderService orderService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderRegisterResponse register(@RequestBody @Validated OrderRegisterRequest request) {
		
		Order order = request.convertToOrder();
		orderService.register(order);
		
		return OrderRegisterResponse.convertFromOrder(order);
		
	}

}
