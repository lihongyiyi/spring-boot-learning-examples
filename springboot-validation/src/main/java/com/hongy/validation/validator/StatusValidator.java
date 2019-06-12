package com.hongy.validation.validator;

import com.hongy.validation.annotation.Status;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * @Author lihongy
 * @Created by on 2019/06/12 11:46.
 * @Description:
 */
public class StatusValidator implements ConstraintValidator<Status, String> {

    private final String[] ALL_STATUS = {"created", "paid", "shipped", "closed"};

    public void initialize(Status status) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(Arrays.asList(ALL_STATUS).contains(value)) {
            return true;
        }
        return false;
    }
}