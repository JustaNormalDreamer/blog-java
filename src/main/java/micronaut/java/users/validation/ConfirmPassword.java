/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.users.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmPasswordRule.class)
public @interface ConfirmPassword {
    String message() default "Confirmation password doesn't match.";

    Class<?>[] groups() default {};

    public abstract Class<? extends Payload>[] payload() default{};
}
