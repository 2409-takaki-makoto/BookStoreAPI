package com.example.BookStore.domain.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.BookStore.domain.values.IPrice;
import com.example.BookStore.domain.values.OrderDate;
import com.example.BookStore.domain.values.OrderQty;
import com.example.BookStore.domain.values.Tax;
import com.example.BookStore.domain.values.TaxRate;
import com.example.BookStore.domain.values.TotalCost;
import com.example.BookStore.domain.values.UnitCost;

public class OrderTest {
	
	private static Order order = new Order();
	private static Book book = new Book();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		book.setPrice(new UnitCost(1000L));
		
		order.setOrderDate(new OrderDate(LocalDateTime.parse("2019-09-01T00:00:00")));
		order.setOrderQty(new OrderQty(15L));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateOrderDetailForPrice() {
		
//		TotalCost mockTotalCost = mock(TotalCost.class);
//		TaxRate mockTaxRate = mock(TaxRate.class);
//		Tax mockTax = mock(Tax.class);
//		
//		OrderDate orderDate = new OrderDate(LocalDateTime.now());
//		TaxRate rate = new TaxRate(0.1f);
		
		
		

		Mockito.mockStatic(TotalCost.class)
			.when(() -> TotalCost.createTotalCostFromUnitCost(isA(UnitCost.class), isA(OrderQty.class))).thenReturn(new TotalCost(1200L));
		
		Mockito.mockStatic(TaxRate.class)
			.when(() -> TaxRate.getTaxRateFromOrderDate(isA(OrderDate.class))).thenReturn(TaxRate.RATE_10);
		
		Mockito.mockStatic(Tax.class)
			.when(() -> Tax.createTaxFromPrice(isA(IPrice.class), isA(TaxRate.class))).thenReturn(new Tax(100L));
		
		when(order.getTaxIncludeTotalCost()).thenReturn(new TotalCost(100L));
		
		System.out.println(order.getTaxIncludeTotalCost());
		
		order.calculateOrderDetailForPrice(book);
		
		assertEquals(new TotalCost(1200L).value(), order.getTotalCost().value());
		assertEquals(TaxRate.RATE_10.value(), order.getTaxRate().value());
		assertEquals(new Tax(100L).value(), order.getTax().value());
	}

}
