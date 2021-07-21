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
import java.util.UUID;

public class ExistsRule implements ConstraintValidator<Exists, UUID> {

    @Inject
    private UserRepository userRepository;

    private String bodyMessage;

    @Override
    public void initialize(Exists constraintAnnotation) {
        this.bodyMessage = constraintAnnotation.bodyMessage();
    }

    @Override
    public boolean isValid(UUID value, @NonNull AnnotationValue<Exists> annotationMetadata, @NonNull ConstraintValidatorContext context) {
        System.out.println(bodyMessage);
        System.out.println(value);

        if(userRepository.findById(value).isEmpty()) {
            return false;
        }

        return true;
    }

}
