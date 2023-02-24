package com.burra.quizletclone.business.responses.cardsets;

import com.burra.quizletclone.entities.concretes.Card;
import com.burra.quizletclone.entities.concretes.Cardset;
import java.util.List;
import lombok.Data;

@Data
public class CardsetGetByIdResponse {

  private int id;
  private String name;
  private List<Card> cards;

  public static CardsetGetByIdResponse FromEntity(Cardset cardset) {
    CardsetGetByIdResponse response = new CardsetGetByIdResponse();

    response.setId(cardset.getId());
    response.setName(cardset.getName());
    response.setCards(cardset.getCards());

    return response;
  }
}
