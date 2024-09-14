package com.example.BookStore.application.api.customvalidation.salesstatuscodecheck;

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
@Constraint(validatedBy = SalesStatusCodeCheckValidator.class)
public @interface SalesStatusCodeCheck {
	String message() default "不正なコード値です";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default {};
	

}
