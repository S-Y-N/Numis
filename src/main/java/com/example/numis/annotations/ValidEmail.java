package com.example.numis.annotations;

import jakarta.validation.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

@Target({TYPE,FIELD,ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidation.class)
@Documented
public @interface ValidEmail {
    String message() default "Invalid email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
