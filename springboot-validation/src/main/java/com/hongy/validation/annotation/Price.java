package com.hongy.validation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.*;

/**
 * @Author lihongy
 * @Created by on 2019/06/12 11:15.
 * @Description:
 */
@Documented
@Target( { ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Min(8000)@Max(10000)
public @interface Price {
    String message() default "错误的价格";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
