package com.burra.quizletclone.business.responses.cardsets;

import com.burra.quizletclone.entities.concretes.Cardset;

import lombok.Data;

@Data
public class CardsetUpdateResponse {
  private String name;

  public static CardsetUpdateResponse FromEntity(Cardset cardset) {
    CardsetUpdateResponse response = new CardsetUpdateResponse();
    response.setName(cardset.getName());

    return response;
  }
}
