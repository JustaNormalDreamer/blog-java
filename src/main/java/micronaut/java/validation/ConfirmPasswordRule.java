/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.validation;

import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.validation.validator.constraints.ConstraintValidator;
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext;
import micronaut.java.users.UserRequest;

public class ConfirmPasswordRule implements ConstraintValidator<ConfirmPassword, UserRequest> {


    @Override
    public boolean isValid(UserRequest value, @NonNull AnnotationValue<ConfirmPassword> annotationMetadata, @NonNull ConstraintValidatorContext context) {
        System.out.println("Validating password check.");
        return value == null || value.getPassword().equals(value.getConfirm_password());
    }

    @Override
    public void initialize(ConfirmPassword constraintAnnotation) {

    }
}
