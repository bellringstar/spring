package com.example.validation.annotation;


import com.example.validation.validator.YearMonthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {YearMonthValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface YearMonth {

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String message() default "날짜 양식에 맞지 않습니다. ex) 20230101";

    String pattern() default "yyyyMM";
}
