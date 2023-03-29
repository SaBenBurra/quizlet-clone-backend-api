package com.burra.quizletclone.business.requests.cardsets;

import java.util.List;

import com.burra.quizletclone.business.requests.cards.CardCreateRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CardsetUpdateRequest {
  @NotBlank
  private String name;

  @Valid
  @NotEmpty
  private List<CardCreateRequest> cards;
}
