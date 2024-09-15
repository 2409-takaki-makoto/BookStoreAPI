package com.example.BookStore.domain.values;

import java.time.LocalDateTime;
import java.util.Objects;

public record TaxRate(Float value) {
	final public static TaxRate RATE_8 = new TaxRate(0.08f);
	final public static TaxRate RATE_10 = new TaxRate(0.10f);

	// 税率が10%に変更された日付
	final private static LocalDateTime TAX_RATE_CHANGE_DATE_TO_010 = LocalDateTime.parse("2019-10-01T00:00:00");

	public TaxRate {
		if (value == null) {
			throw new IllegalArgumentException("消費税率の初期化に失敗");
		}
	}
	
	/**
	 * 注文日から消費税率を取得する
	 */
	public static TaxRate getTaxRateFromOrderDate(OrderDate orderDate) {
		
		if (orderDate.isBeforeDate(TAX_RATE_CHANGE_DATE_TO_010)) {
			return RATE_8;
		}
		
		return RATE_10;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (Objects.equals(this, obj)) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof TaxRate)) {
			return Boolean.FALSE;
		}

		TaxRate otherObj = (TaxRate) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}
}
