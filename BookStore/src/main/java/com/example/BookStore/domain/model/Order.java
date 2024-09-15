package com.example.BookStore.domain.model;

import java.util.Objects;

import com.example.BookStore.domain.values.BookId;
import com.example.BookStore.domain.values.CreatedDate;
import com.example.BookStore.domain.values.OrderDate;
import com.example.BookStore.domain.values.OrderId;
import com.example.BookStore.domain.values.OrderQty;
import com.example.BookStore.domain.values.OrderStatusCode;
import com.example.BookStore.domain.values.Tax;
import com.example.BookStore.domain.values.TaxRate;
import com.example.BookStore.domain.values.TotalCost;
import com.example.BookStore.domain.values.UnitCost;
import com.example.BookStore.domain.values.UpdatedDate;
import com.example.BookStore.domain.values.UserId;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
	private OrderId id;
	private UserId userId;
	private BookId bookId;
	private OrderQty orderQty;
	private UnitCost unitCost;
	private TaxRate taxRate;
	private TotalCost totalCost;
	private Tax tax;
	private OrderDate orderDate;
	private OrderStatusCode orderStatusCode;
	private CreatedDate createdDate;
	private UpdatedDate updatedDate;
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (Objects.equals(this, obj)) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof Order)) {
			return Boolean.FALSE;
		}

		Order otherObj = (Order) obj;

		if (this.id == null) {
			if (otherObj.id == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.id.equals(otherObj.id);
	}
	
	/**
	 * 
	 * 合計金額の税込価格を算出する
	 * 
	 * @return
	 */
	public TotalCost getTaxIncludeTotalCost() {
		return this.totalCost.caluculateOfIncludeTax(this.tax);
	}
	
	/**
	 * 注文の料金に関する明細情報を作成する
	 * 
	 * @param book
	 */
	public void calculateOrderDetailForPrice(Book book) {
		this.unitCost = book.getPrice();
		this.totalCost = TotalCost.createTotalCostFromUnitCost(book.getPrice(), this.orderQty);
		
		// 消費税の設定
		this.taxRate = TaxRate.getTaxRateFromOrderDate(this.orderDate);
		// 消費税額の設定
		this.tax = Tax.createTaxFromPrice(this.totalCost , this.taxRate);
		
	}

}
