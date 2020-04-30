package com.soft1851.springboot.validator.annotation;

import com.soft1851.springboot.validator.validator.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * @author ZENG
 */
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {

    String message() default "phoneNumber 格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
