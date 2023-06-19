package com.example.numis.annotations;

import com.example.numis.domain.models.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidation implements ConstraintValidator<ValidPassword, Object> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        User user = (User) obj;
        return user.getPassword().compareTo(user.getPasswordConfirmation())==0;
    }
}
