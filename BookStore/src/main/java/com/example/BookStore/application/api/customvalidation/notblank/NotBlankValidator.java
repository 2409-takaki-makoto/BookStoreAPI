package com.example.BookStore.application.api.customvalidation.notblank;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotBlankValidator implements ConstraintValidator<NotBlank, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if (Objects.isNull(value)) {
			return false;
		}
		
		return value.strip().length() > 0;
	}

}
