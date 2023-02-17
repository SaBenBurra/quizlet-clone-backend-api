package com.burra.quizletclone.business.responses.cards;

import com.burra.quizletclone.entities.concretes.Card;

import lombok.Data;

@Data
public class CardUpdateResponse {
  
  private int id;
  private String definition;
  private String term;

  public static CardUpdateResponse FromEntity(Card card) {
    CardUpdateResponse response = new CardUpdateResponse();
    response.setId(card.getId());
    response.setTerm(card.getTerm());
    response.setDefinition(card.getDefinition());

    return response;
  }
  
}
