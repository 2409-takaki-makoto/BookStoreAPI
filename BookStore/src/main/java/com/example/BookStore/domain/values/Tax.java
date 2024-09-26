package com.example.BookStore.domain.values;

public record Tax(Long value) {

	public Tax {
		if (value == null) {
			value = 0L;
		}
	}

	/**
	 * 
	 * <p>消費税額を作成する</p>
	 * 
	 * <dd>金額と税率から消費税額を取得する</dd>
	 * 
	 * @param price
	 * @param taxRate
	 * @return
	 */
	public static Tax createTaxFromPrice(IPrice price, TaxRate taxRate) {
		double amount = price.value() * taxRate.value();

		return new Tax((long) Math.floor(amount));

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (this == obj) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof Tax)) {
			return Boolean.FALSE;
		}

		Tax otherObj = (Tax) obj;

		return this.value.equals(otherObj.value);
	}
}
