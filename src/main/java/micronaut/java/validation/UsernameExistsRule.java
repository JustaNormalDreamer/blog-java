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
import micronaut.java.users.UserRepository;

import javax.inject.Inject;

public class UsernameExistsRule implements ConstraintValidator<UsernameExists, String> {

    @Inject
    private UserRepository userRepository;

    @Override
    public boolean isValid(String value, @NonNull  AnnotationValue<UsernameExists> annotationMetadata, @NonNull  ConstraintValidatorContext context) {
        return value != null && userRepository.countByUsername(value) < 1;
    }
}
