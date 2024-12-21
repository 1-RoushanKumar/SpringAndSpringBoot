package com.rOushAn.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // Fixed the attribute name to `validatedBy`
@Target({ElementType.METHOD, ElementType.FIELD}) // Annotation can be applied to methods and fields
@Retention(RetentionPolicy.RUNTIME) // Retain the annotation at runtime
public @interface CourseCode {

    // Define default course code
    public String value() default "LUV";

    // Define default error message
    public String message() default "must start with LUV";

    // Define default groups
    public Class<?>[] groups() default {};

    // Define default payload
    public Class<? extends Payload>[] payload() default {};
}
