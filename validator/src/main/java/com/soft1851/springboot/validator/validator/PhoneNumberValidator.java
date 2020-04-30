package com.soft1851.springboot.validator.validator;

import com.soft1851.springboot.validator.annotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author Zeng
 * @ClassName PhoneNumberValidator
 * @Description TOOD
 * @Date 2020/4/30
 * @Version 1.0
 **/
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("^1(3|4|5|7|8)\\d{9}$");
        return pattern.matcher(s).matches();
    }
}
