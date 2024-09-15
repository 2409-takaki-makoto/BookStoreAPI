package com.example.BookStore.application.api.response;

import com.example.BookStore.domain.model.Order;

import lombok.Data;

@Data
public class OrderRegisterResponse {
	private Long id;
	private Long unitCost;
	private Long totalCost;
	private Long tax;
	private Long taxIncludeTotalCost;
	
	public static OrderRegisterResponse convertFromOrder(Order order) {
		OrderRegisterResponse response = new OrderRegisterResponse();
		response.setId(order.getId().value());
		response.setUnitCost(order.getUnitCost().value());
		response.setTotalCost(order.getTotalCost().value());
		response.setTaxIncludeTotalCost(order.getTaxIncludeTotalCost().value());
		response.setTax(order.getTax().value());
		
		return response;
	}
}
