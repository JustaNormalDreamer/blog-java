/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistsRule.class)
public @interface Exists {
    String message() default "Model already exists.";

    Class<?>[] groups() default {};

    public abstract Class<? extends Payload>[] payload() default{};

    String bodyMessage() default "This is the test message.";

}
