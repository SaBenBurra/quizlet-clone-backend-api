package com.burra.quizletclone.business.services.abstracts;

import com.burra.quizletclone.business.requests.cardsets.CardsetCreateRequest;
import com.burra.quizletclone.business.responses.cardsets.CardsetCreateResponse;
import com.burra.quizletclone.core.utilities.results.DataResult;
import com.burra.quizletclone.entities.concretes.Cardset;
import java.util.ArrayList;

public interface CardsetService {
  public DataResult<ArrayList<Cardset>> getAll();

  public DataResult<CardsetCreateResponse> create(CardsetCreateRequest request);
}
