package com.example.BookStore.application.api.customvalidation.notblank;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NotBlankValidator.class)
public @interface NotBlank {
	String message() default "入力してください";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default {};
	

}
