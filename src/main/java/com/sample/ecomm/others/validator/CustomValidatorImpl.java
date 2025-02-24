package com.sample.ecomm.others.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidatorImpl implements ConstraintValidator<CustomValidator, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false; // Null or empty values are invalid
        }
        return value.matches("^[A-Z][a-z]*$"); // Value must start with an uppercase letter
    }
}
