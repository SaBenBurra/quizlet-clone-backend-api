package com.burra.quizletclone.business.services.abstracts;

import java.util.ArrayList;

import com.burra.quizletclone.business.requests.cards.CardCreateRequest;
import com.burra.quizletclone.core.utilities.results.DataResult;
import com.burra.quizletclone.entities.concretes.Card;

/**
 * CardService
 */
public interface CardService {

  public DataResult<ArrayList<Card>> getAll();

  public DataResult<Card> create(CardCreateRequest request);
}
