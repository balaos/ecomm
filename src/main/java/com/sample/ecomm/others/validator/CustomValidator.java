package com.sample.ecomm.others.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CustomValidatorImpl.class) // Links to validator class
@Target(ElementType.FIELD) // Applies to fields
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime
public @interface CustomValidator {

    String message() default "Invalid value"; // Default error message

    Class<?>[] groups() default {}; // Used for grouping constraints

    Class<? extends Payload>[] payload() default {}; // Additional metadata
}

