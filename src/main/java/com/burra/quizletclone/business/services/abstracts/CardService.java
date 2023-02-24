package com.burra.quizletclone.business.services.abstracts;

import java.util.ArrayList;

import com.burra.quizletclone.business.requests.cards.CardCreateRequest;
import com.burra.quizletclone.business.requests.cards.CardUpdateRequest;
import com.burra.quizletclone.business.responses.cards.CardCreateResponse;
import com.burra.quizletclone.business.responses.cards.CardGetByIdResponse;
import com.burra.quizletclone.business.responses.cards.CardUpdateResponse;
import com.burra.quizletclone.core.utilities.results.DataResult;
import com.burra.quizletclone.core.utilities.results.Result;
import com.burra.quizletclone.entities.concretes.Card;

/**
 * CardService
 */
public interface CardService {

  public DataResult<ArrayList<Card>> getAll();

  public DataResult<CardGetByIdResponse> getById(int cardId);

  public DataResult<CardCreateResponse> create(CardCreateRequest request);

  public Result delete(int cardId);

  public DataResult<CardUpdateResponse> update(CardUpdateRequest request, int cardId);
}
