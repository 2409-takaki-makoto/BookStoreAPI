package com.example.BookStore.domain.values;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public record SalesStatusCode(String value) {
	public SalesStatusCode {
		
		if (value == null) value = "00";
		
		if (!CODE_LIST.containsKey(value)) {
			throw new IllegalArgumentException("販売ステータスコードの初期化に失敗");
		}
	}

	final private static Map<String, String> CODE_LIST = new HashMap<>();
	static {
		CODE_LIST.put("00", "販売中止");
		CODE_LIST.put("01", "販売中");
	}

	/** 販売中止 */
	final public static SalesStatusCode DISCOUNTINUE = new SalesStatusCode("00");
	/** 販売中 */
	final public static SalesStatusCode SALL = new SalesStatusCode("01");


	/**
	 * コードリスト取得
	 * 
	 * @return
	 */
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

		if (!(obj instanceof SalesStatusCode)) {
			return Boolean.FALSE;
		}

		SalesStatusCode otherObj = (SalesStatusCode) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);
	}
}
