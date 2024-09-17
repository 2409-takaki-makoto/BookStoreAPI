package com.example.BookStore.domain.values;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public record OrderDate(LocalDateTime value) {

	public OrderDate {
		if (value == null) {
			value = LocalDateTime.now();
		}
	}

	/**
	 * <p>注文日の前日判定</p>
	 * 
	 * <dd>注文日が入力された日付よりも前の日付であるか判定する</dd>
	 * @return
	 */
	public boolean isBeforeDate(LocalDateTime date) {
		LocalDate inputDate = date.toLocalDate();
		LocalDate orderDate = this.value.toLocalDate();

		return orderDate.isBefore(inputDate);
	}

	public String formatDisplay() {
		return value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		}

		if (Objects.equals(this, obj)) {
			return Boolean.TRUE;
		}

		if (!(obj instanceof OrderDate)) {
			return Boolean.FALSE;
		}

		OrderDate otherObj = (OrderDate) obj;

		if (this.value == null) {
			if (otherObj.value == null) {
				return Boolean.TRUE;
			}

			return Boolean.FALSE;
		}

		return this.value.equals(otherObj.value);

	}

}
