package com.hongy.validation.annotation;

import com.hongy.validation.validator.StatusValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author lihongy
 * @Created by on 2019/06/12 11:44.
 * @Description:
 */
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StatusValidator.class})
public @interface Status {
    String message() default "不正确的状态 , 应该是 'created', 'paid', shipped', closed'其中之一";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
