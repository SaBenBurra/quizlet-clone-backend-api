package com.burra.quizletclone.business.responses.cards;

import com.burra.quizletclone.entities.concretes.Card;
import lombok.Data;

@Data
public class CardCreateResponse {

  private int id;
  private String definition;
  private String term;

  public static CardCreateResponse FromEntity(Card card) {
    CardCreateResponse response = new CardCreateResponse();

    response.setId(card.getId());
    response.setDefinition(card.getDefinition());
    response.setTerm(card.getTerm());

    return response;
  }
}
