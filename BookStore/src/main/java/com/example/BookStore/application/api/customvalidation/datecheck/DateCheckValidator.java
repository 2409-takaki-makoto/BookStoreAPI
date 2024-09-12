package com.example.BookStore.application.api.customvalidation.datecheck;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 日付形式の文字列を厳密にチェックします。
 * 日付形式： yyyy-MM-dd HH:mm:ss または yyyy-MM-dd
 * 
 * @return
 * 存在しない日付はFalse（うるう年のチェックも実施）</br>
 * 入力された日付が31日の場合、その月に31日が存在しなければFalseになります。
 */
public class DateCheckValidator implements ConstraintValidator<DateCheck, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value == null) {
			return true;
		}

		if (value.matches(
				"^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]) ([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$")) {
			return parseCheck(value);
		} else if (value.matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$")) {
			return parseCheck(value + " 00:00:00");
		}

		return false;
	}

	private boolean parseCheck(String strDate) {
		DateTimeFormatter format = DateTimeFormatter
				.ofPattern("uuuu-MM-dd HH:mm:ss")
				.withResolverStyle(ResolverStyle.STRICT);

		try {

			LocalDateTime.parse(strDate, format);

		} catch (DateTimeParseException e) {
			return false;
		}

		return true;
	}

}
