package com.example.BookStore.application.api.customvalidation.datecheck;

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
@Constraint(validatedBy = DateCheckValidator.class)
public @interface DateCheck {
	String message() default "日付の形式に誤りがあります";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default {};
	

}
