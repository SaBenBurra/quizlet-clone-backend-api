package com.burra.quizletclone.business.services.concretes;

import com.burra.quizletclone.business.requests.cards.CardCreateRequest;
import com.burra.quizletclone.business.requests.cards.CardUpdateRequest;
import com.burra.quizletclone.business.responses.cards.CardCreateResponse;
import com.burra.quizletclone.business.responses.cards.CardGetByIdResponse;
import com.burra.quizletclone.business.responses.cards.CardUpdateResponse;
import com.burra.quizletclone.business.services.abstracts.CardService;
import com.burra.quizletclone.core.utilities.results.DataResult;
import com.burra.quizletclone.core.utilities.results.Result;
import com.burra.quizletclone.core.utilities.results.SuccessDataResult;
import com.burra.quizletclone.core.utilities.results.SuccessResult;
import com.burra.quizletclone.dataAccess.abstracts.CardRepository;
import com.burra.quizletclone.dataAccess.abstracts.CardsetRepository;
import com.burra.quizletclone.entities.concretes.Card;
import com.burra.quizletclone.entities.concretes.Cardset;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class CardManager implements CardService {

  CardRepository cardRepository;
  CardsetRepository cardsetRepository;

  public CardManager(
    CardRepository cardRepository,
    CardsetRepository cardsetRepository
  ) {
    this.cardRepository = cardRepository;
    this.cardsetRepository = cardsetRepository;
  }

  @Override
  public DataResult<ArrayList<Card>> getAll(Long cardsetId) {
    ArrayList<Card> cards = (ArrayList<Card>) (
      (cardsetId != null)
        ? cardRepository.findAll()
        : cardRepository.findByCardsetId(cardsetId)
    );
    return new SuccessDataResult<ArrayList<Card>>(cards);
  }

  @Override
  public DataResult<CardGetByIdResponse> getById(int cardId) {
    Card card = cardRepository.getReferenceById(cardId);
    CardGetByIdResponse response = CardGetByIdResponse.FromEntity(card);

    return new SuccessDataResult<CardGetByIdResponse>(response);
  }

  @Override
  public Result delete(int cardId) {
    cardRepository.deleteById(cardId);
    return new SuccessResult();
  }

  @Override
  public DataResult<CardUpdateResponse> update(
    CardUpdateRequest request,
    int cardId
  ) {
    Card card = cardRepository.getReferenceById(cardId);
    card.setTerm(request.getTerm());
    card.setDefinition(request.getDefinition());

    Card updatedCard = cardRepository.save(card);
    CardUpdateResponse response = CardUpdateResponse.FromEntity(updatedCard);

    return new SuccessDataResult<CardUpdateResponse>(response);
  }
}
