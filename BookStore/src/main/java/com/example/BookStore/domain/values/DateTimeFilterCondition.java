package com.example.BookStore.domain.values;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.BookStore.application.exception.BusinessException;
import com.example.BookStore.application.exception.error.ErrorObject;

/**
 * 開始日時と終了日時の絞り込み条件を管理する値オブジェクト
 */
public record DateTimeFilterCondition(
		LocalDateTime start,
		LocalDateTime end) {

	public DateTimeFilterCondition {
		if (start == null) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			start = LocalDateTime.parse("2020-01-01 00:00:00", format);
		}

		if (end == null) {
			end = LocalDateTime.now();
		}

		if (!dateCorrelationCheck(start, end)) {
			throw new BusinessException(ErrorObject.日付の絞り込み条件では開始日は終了日より未来日を設定できません);
		}
	}

	/**
	 * <DD>開始日と終了日の相関チェック</DD>
	 * 
	 * チェック詳細</br>
	 * 開始日日付が終了日日付を追い越している場合はNG
	 * 
	 * @return
	 * OKの時 True</br>
	 * NGの時 False
	 */
	private boolean dateCorrelationCheck(LocalDateTime start, LocalDateTime end) {

		// 開始日の日付追い越しチェック.
		if (start.isAfter(end)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (this == obj) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof DateTimeFilterCondition)) {
			return Boolean.FALSE;
		}

		DateTimeFilterCondition otherObj = (DateTimeFilterCondition) obj;

		return this.start.equals(otherObj.start) && this.end.equals(otherObj.end);
	}
}
