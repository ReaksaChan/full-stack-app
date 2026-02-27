package com.arjuncodes.studentsystem.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValueValidator.class)
public @interface ValidEnum {
    String message() default "invalid enum value";
    Class<? extends Enum<?>> enumClass();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
