package com.burra.quizletclone.business.responses.cardsets;

import com.burra.quizletclone.entities.concretes.Cardset;
import lombok.Data;

@Data
public class CardsetCreateResponse {

  private int id;
  private String name;

  public static CardsetCreateResponse FromEntity(Cardset cardset) {
    CardsetCreateResponse response = new CardsetCreateResponse();
    response.setName(cardset.getName());
    response.setId(cardset.getId());

    return response;
  }
}
