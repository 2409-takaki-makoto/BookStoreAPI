package com.example.BookStore.domain.model.user;

import com.example.BookStore.domain.values.DateTimeFilterCondition;
import com.example.BookStore.domain.values.SearchResultLimit;

import lombok.Data;

/**
 * ユーザーの検索条件に関する情報を管理する
 */
@Data
public class UserSearchCondition {
	/** 検索結果の上限数 デフォルト：1000件 */
	private SearchResultLimit limit = new SearchResultLimit(1000L);
	/** 開始日と終了日で絞り込みを行う条件情報 */
	private DateTimeFilterCondition filterCondition;
	
}
