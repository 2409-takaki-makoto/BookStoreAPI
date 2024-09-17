package com.example.BookStore.domain.values;

import java.util.Objects;

/**
 * 検索結果の上限数を管理する値オブジェクト
 */
public record SearchResultLimit(Long value) {
	
	/** 定数： 検索上限数のデフォルト値 */
	final public static Long LIMIT_DEFAULT = 1_000L;
	/** 定数： 最大検索上限数 */
	final public static Long LIMIT_MAX = 10_000L;
	
	/**
	 * コンストラクタ
	 * 
	 * @param value 設定なし（null）の場合は、デフォルト値：1000を設定します。
	 */
	public SearchResultLimit(Long value) {
		
		if (value == null) {
			value = LIMIT_DEFAULT;
		} else {
			if (!limitRangeCheck(value)) {
				throw new IllegalArgumentException("上限数が有効範囲外");
			}
		}
		
		this.value = value;
		
	}
	
	/**
	 * <p>検索上限数有効範囲チェック</p>
	 * 
	 * <p>設定値が範囲内であるか検証する。</p>
	 * 	<dl>
	 * 		<dt>以下のチェックを行い、NGとなる条件が無ければOKと判定します。<dt>
	 * 		<dd>
	 * 			<ul>
	 * 				<li>設定値がマイナスの場合はNG</li>
	 * 				<li>設定値が0の場合はNG</li>
	 * 				<li>設定値が10,000件を超える場合はNG</li>
	 * 			</ul>
	 * 		</dd>
	 * 
	 * @param value
	 * @return
	 * 	OKの場合は{@code TRUE}を返却します。
	 */
	public static boolean limitRangeCheck(Long value) {
		if (value > 0L && value <= LIMIT_MAX) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (Objects.equals(this, obj)) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof SearchResultLimit)) {
			return Boolean.FALSE;
		}

		SearchResultLimit otherObj = (SearchResultLimit) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);

	}

}
