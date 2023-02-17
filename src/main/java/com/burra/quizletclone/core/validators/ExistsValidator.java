package com.burra.quizletclone.core.validators;

import com.burra.quizletclone.core.annotations.Exists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ExistsValidator
  implements ConstraintValidator<Exists, Integer> {

  private String table;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void initialize(Exists uniqueValueAnnotation) {
    this.table = uniqueValueAnnotation.table();
  }

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    int count = jdbcTemplate.queryForObject(
      "SELECT COUNT(*) FROM " + table + " WHERE id = ?",
      new Object[] { value },
      Integer.class
    );
    boolean result = count > 0;

    if (!result) {
      context.disableDefaultConstraintViolation();
      context
        .buildConstraintViolationWithTemplate(
          "bu veri, veri tabanında yok"
        )
        .addConstraintViolation();
    }
    return result;
  }
}
