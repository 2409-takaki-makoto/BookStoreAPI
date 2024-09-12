package com.example.BookStore.application.api.request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.util.Strings;

import com.example.BookStore.application.api.customvalidation.datecheck.DateCheck;
import com.example.BookStore.domain.values.DateTimeFilterCondition;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DateFilterObject {

	@DateCheck
	private String start;

	@DateCheck
	private String end;

	public DateTimeFilterCondition convertToDomain() {
		return new DateTimeFilterCondition(getStartConvToLocalDdateTime(), getEndConvToLocalDateTime());
	}

	private LocalDateTime getStartConvToLocalDdateTime() {
		if (Strings.isBlank(start)) {
			return null;
		}

		return convertToLocalDdateTime(this.start);
	}

	private LocalDateTime getEndConvToLocalDateTime() {
		if (Strings.isBlank(this.end)) {
			return null;
		}

		return convertToLocalDdateTime(this.end);
	}

	private LocalDateTime convertToLocalDdateTime(String strDate) {

		if (strDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
			strDate += " 00:00:00";
		}

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		return LocalDateTime.parse(strDate, format);

	}
}
