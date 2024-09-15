package com.example.BookStore.domain.values;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public record OrderStatusCode(String value) {

	public OrderStatusCode {

		if (value == null || !CODE_LIST.containsKey(value)) {
			throw new IllegalArgumentException("注文ステータスコードの初期化に失敗");
		}

	}

	final private static Map<String, String> CODE_LIST = new HashMap<>();

	static {
		CODE_LIST.put("00", "キャンセル済み");
		CODE_LIST.put("01", "入金待ち");
		CODE_LIST.put("02", "発送済み");
		CODE_LIST.put("03", "完了");
	}

	/** キャンセル済み */
	final public static OrderStatusCode CANCEL = new OrderStatusCode("00");
	/** 入金待ち */
	final public static OrderStatusCode AWAIT_PAYMENT = new OrderStatusCode("01");
	/** 発送済み */
	final public static OrderStatusCode SHIPPED = new OrderStatusCode("02");
	/** 完了 */
	final public static OrderStatusCode COMPLATED = new OrderStatusCode("03");

	public static Map<String, String> getCodeList() {
		return new HashMap<>(CODE_LIST);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (Objects.equals(this, obj)) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof OrderStatusCode)) {
			return Boolean.FALSE;
		}

		OrderStatusCode otherObj = (OrderStatusCode) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}
}
