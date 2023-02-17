package com.burra.quizletclone.core.annotations;

import com.burra.quizletclone.core.validators.UniqueValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueValidator.class)
public @interface UniqueValue {

  String message() default "";

  String table();

  String column();

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
