package com.burra.quizletclone.business.requests.cards;

import com.burra.quizletclone.core.annotations.Exists;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CardCreateRequest {

  @NotBlank
  @Exists(table = "cardsets")
  private int cardsetId;

  @NotBlank
  private String definition;

  @NotBlank
  private String term;

}
