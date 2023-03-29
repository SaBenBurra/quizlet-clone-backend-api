package com.burra.quizletclone.business.responses.cardsets;

import java.util.List;

import com.burra.quizletclone.business.responses.cards.CardCreateResponse;
import com.burra.quizletclone.entities.concretes.Cardset;

import lombok.Data;

@Data
public class CardsetUpdateResponse {
  private String name;

  private List<CardCreateResponse> cards;

  public static CardsetUpdateResponse FromEntity(Cardset cardset) {
    CardsetUpdateResponse response = new CardsetUpdateResponse();
    response.setName(cardset.getName());

    return response;
  }
}
