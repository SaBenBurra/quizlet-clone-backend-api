package com.burra.quizletclone.business.requests.cardsets;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CardsetCreateRequest {

  @NotBlank
  private String name;

}
