package com.example.BookStore.application.api.customvalidation.salesstatuscodecheck;

import java.util.Map;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import com.example.BookStore.domain.values.SalesStatusCode;

/**
 * 販売ステータスコードが正しいか判定します。
 * 
 * @return
 * 販売ステータスコードに設定されているコードと異なる値が設定されている場合はfalseを返却します。
 */
public class SalesStatusCodeCheckValidator implements ConstraintValidator<SalesStatusCodeCheck, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value == null) {
			return true;
		}
		
		Map<String, String> CODE_LIST = SalesStatusCode.getCodeList();
		if (CODE_LIST.containsKey(value)) {
			return true;
		}
		
		
		return false;
	}

}
