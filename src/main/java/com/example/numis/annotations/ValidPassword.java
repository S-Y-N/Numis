package com.example.numis.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidation.class)
@Documented
public @interface ValidPassword {
    String message() default "Passwords don't match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
