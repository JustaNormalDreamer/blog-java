/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.validation.matches;

import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.validation.validator.constraints.ConstraintValidator;
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext;
import micronaut.java.users.UserRequest;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, UserRequest> {

//    private String field;
//    private String fieldMatch;

    @Override
    public boolean isValid(UserRequest value, @NonNull  AnnotationValue<FieldMatch> annotationMetadata, @NonNull  ConstraintValidatorContext context) {
        assert value != null;
        System.out.println(value.getPassword());
        System.out.println(value.getConfirm_password());
        return value.getPassword().equals(value.getConfirm_password());
    }

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
//        field = constraintAnnotation.field();
//        fieldMatch = constraintAnnotation.fieldMatch();
    }
}
