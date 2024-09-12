package com.example.BookStore.domain.values;

/**
 * 検索結果の上限数を管理する値オブジェクト
 */
public record SearchResultLimit(Long value) {
	
	final private static Long LIMIT_DEFAULT = 1000L;
	
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
	 * <p>設定値が範囲内であるか検証する。</p>
	 * 	<dl>
	 * 		<dt>以下のチェックを行い、NGとなる条件が無ければOKと判定します。<dt>
	 * 		<dd>
	 * 			<ul>
	 * 				<li>設定値がマイナスの場合はNG</li>
	 * 				<li>設定値が0の場合はNG</li>
	 * 				<li>設定値が10000を超える場合はNG</li>
	 * 			</ul>
	 * 		</dd>
	 * 
	 * @param value
	 * @return
	 * 	OKの場合は{@code TRUE}を返却します。
	 */
	private boolean limitRangeCheck(Long value) {
		if (value > 0L && value <= 10000L) {
			return true;
		}
		
		return false;
	}

}
