package com.burra.quizletclone.business.services.concretes;

import com.burra.quizletclone.business.requests.cardsets.CardsetCreateRequest;
import com.burra.quizletclone.business.responses.cardsets.CardsetCreateResponse;
import com.burra.quizletclone.business.services.abstracts.CardsetService;
import com.burra.quizletclone.core.utilities.results.DataResult;
import com.burra.quizletclone.core.utilities.results.Result;
import com.burra.quizletclone.core.utilities.results.SuccessDataResult;
import com.burra.quizletclone.core.utilities.results.SuccessResult;
import com.burra.quizletclone.dataAccess.abstracts.CardsetRepository;
import com.burra.quizletclone.entities.concretes.Cardset;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class CardsetManager implements CardsetService {

  private CardsetRepository cardsetRepository;

  public CardsetManager(CardsetRepository cardsetRepository) {
    this.cardsetRepository = cardsetRepository;
  }

  @Override
  public DataResult<ArrayList<Cardset>> getAll() {
    ArrayList<Cardset> cardsets = (ArrayList<Cardset>) cardsetRepository.findAll();

    return new SuccessDataResult<ArrayList<Cardset>>(
      cardsets,
      "Setler listelendi."
    );
  }

  @Override
  public DataResult<CardsetCreateResponse> create(
    CardsetCreateRequest request
  ) {
    Cardset cardset = new Cardset();
    cardset.setName(request.getName());

    Cardset newCardset = cardsetRepository.save(cardset);
    return new SuccessDataResult<CardsetCreateResponse>(
      CardsetCreateResponse.FromEntity(newCardset)
    );
  }

  @Override
  public Result delete(int cardsetId) {
    cardsetRepository.deleteById(cardsetId);
    return new SuccessResult("Set başarıyla silindi");
  }
}
