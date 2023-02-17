package com.burra.quizletclone.core.validators;

import com.burra.quizletclone.core.annotations.UniqueValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UniqueValueValidator
  implements ConstraintValidator<UniqueValue, Object> {

  private String column;
  private String table;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void initialize(UniqueValue uniqueValueAnnotation) {
    this.column = uniqueValueAnnotation.column();
    this.table = uniqueValueAnnotation.table();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    int count = jdbcTemplate.queryForObject(
      "SELECT COUNT(*) FROM " + table + " WHERE " + column + " = ?",
      new Object[] { value },
      Integer.class
    );
    boolean result = count == 0;

    if (!result) {
      context.disableDefaultConstraintViolation();
      context
        .buildConstraintViolationWithTemplate(
          value + " değeri zaten var"
        )
        .addConstraintViolation();
    }
    return result;
  }
}
