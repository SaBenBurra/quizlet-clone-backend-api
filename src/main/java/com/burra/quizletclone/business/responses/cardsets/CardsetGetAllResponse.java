package com.burra.quizletclone.business.responses.cardsets;

import com.burra.quizletclone.entities.concretes.Cardset;
import lombok.Data;

@Data
public class CardsetGetAllResponse {

  private int id;
  private String name;
  private int cardCount;

  public static CardsetGetAllResponse FromEntity(Cardset cardset) {
    CardsetGetAllResponse response = new CardsetGetAllResponse();

    response.setId(cardset.getId());
    response.setName(cardset.getName());
    response.setCardCount(cardset.getCards().size());

    return response;
  }
}
