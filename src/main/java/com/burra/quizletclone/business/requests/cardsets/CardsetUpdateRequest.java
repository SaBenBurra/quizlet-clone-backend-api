package com.burra.quizletclone.business.requests.cardsets;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CardsetUpdateRequest {
  @NotBlank
  private String name;
}
