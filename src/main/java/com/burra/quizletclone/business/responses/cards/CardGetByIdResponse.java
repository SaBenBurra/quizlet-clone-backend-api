package com.burra.quizletclone.business.responses.cards;

import com.burra.quizletclone.entities.concretes.Card;
import lombok.Data;

@Data
public class CardGetByIdResponse {

  private int id;
  private String definition;
  private String term;

  public static CardGetByIdResponse FromEntity(Card card) {
    CardGetByIdResponse response = new CardGetByIdResponse();

    response.setId(card.getId());
    response.setTerm(card.getTerm());
    response.setDefinition(card.getDefinition());

    return response;
  }
}
