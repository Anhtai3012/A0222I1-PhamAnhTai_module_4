package com.codegym.e2.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValiGenre.class)
@Target({ElementType.FIELD})
public @interface ValidateGenre {
    String message() default "not exits";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
