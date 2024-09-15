package com.example.BookStore.domain.values;

import java.util.Objects;

public record Tax(Long value) {

	public Tax(Long value) {
		if (value == null) {
			value = 0L;
		}
		
		this.value = value;
	}
	
	/**
	 * 
	 * 金額と税率から消費税額を取得する
	 * 
	 * @param price
	 * @param taxRate
	 * @return
	 */
	public static Tax createTaxFromPrice(IPrice price, TaxRate taxRate) {
		double amount = price.value() * taxRate.value();
		
		return new Tax((long)Math.floor(amount));
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (Objects.equals(this, obj)) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof Tax)) {
			return Boolean.FALSE;
		}

		Tax otherObj = (Tax) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}
}
