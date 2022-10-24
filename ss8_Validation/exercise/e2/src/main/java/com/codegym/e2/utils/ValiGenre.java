package com.codegym.e2.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValiGenre implements ConstraintValidator<ValidateGenre, String> {
    @Override
    public void initialize(ValidateGenre constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !value.matches("[$&+:;=?@#|'<>.-^*()%!]");
    }
}
