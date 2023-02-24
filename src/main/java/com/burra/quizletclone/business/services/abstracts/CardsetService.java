package com.burra.quizletclone.business.services.abstracts;

import com.burra.quizletclone.business.requests.cardsets.CardsetCreateRequest;
import com.burra.quizletclone.business.requests.cardsets.CardsetUpdateRequest;
import com.burra.quizletclone.business.responses.cardsets.CardsetCreateResponse;
import com.burra.quizletclone.business.responses.cardsets.CardsetGetByIdResponse;
import com.burra.quizletclone.business.responses.cardsets.CardsetUpdateResponse;
import com.burra.quizletclone.core.utilities.results.DataResult;
import com.burra.quizletclone.core.utilities.results.Result;
import com.burra.quizletclone.entities.concretes.Cardset;
import java.util.ArrayList;

public interface CardsetService {
  public DataResult<ArrayList<Cardset>> getAll();

  public DataResult<CardsetGetByIdResponse> getById(int cardsetId);

  public DataResult<CardsetCreateResponse> create(CardsetCreateRequest request);

  public Result delete(int cardsetId);

  public DataResult<CardsetUpdateResponse> update(CardsetUpdateRequest request, int cardsetId);
}
