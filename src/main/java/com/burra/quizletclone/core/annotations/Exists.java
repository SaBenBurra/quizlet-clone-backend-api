package com.burra.quizletclone.core.annotations;

import com.burra.quizletclone.core.validators.ExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistsValidator.class)
public @interface Exists {

  String message() default "";

  String table();

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
