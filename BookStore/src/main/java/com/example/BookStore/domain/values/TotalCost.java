package com.example.BookStore.domain.values;

import java.util.Objects;

public record TotalCost(Long value) implements IPrice {

	public TotalCost(Long value) {
		if (value == null) {
			value = 0L;
		}
		
		this.value = value;
	}
	
	/**
	 * 税込価格を算出する。
	 * 
	 * @param tax
	 * @return
	 */
	public TotalCost caluculateOfIncludeTax(Tax tax) {
		return new TotalCost(this.value + tax.value());
	}
	
	/**
	 * 単価と数量から合計金額を算出する
	 */
	public static TotalCost createTotalCostFromUnitCost(UnitCost unitCost, OrderQty orderQty) {
		return new TotalCost(unitCost.value() * orderQty.value());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (Objects.equals(this, obj)) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof TotalCost)) {
			return Boolean.FALSE;
		}

		TotalCost otherObj = (TotalCost) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}
}
