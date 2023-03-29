package com.burra.quizletclone.business.services.concretes;

import com.burra.quizletclone.business.requests.cards.CardCreateRequest;
import com.burra.quizletclone.business.requests.cardsets.CardsetCreateRequest;
import com.burra.quizletclone.business.requests.cardsets.CardsetUpdateRequest;
import com.burra.quizletclone.business.responses.cardsets.CardsetCreateResponse;
import com.burra.quizletclone.business.responses.cardsets.CardsetGetAllResponse;
import com.burra.quizletclone.business.responses.cardsets.CardsetGetByIdResponse;
import com.burra.quizletclone.business.responses.cardsets.CardsetUpdateResponse;
import com.burra.quizletclone.business.services.abstracts.CardService;
import com.burra.quizletclone.business.services.abstracts.CardsetService;
import com.burra.quizletclone.core.utilities.results.DataResult;
import com.burra.quizletclone.core.utilities.results.Result;
import com.burra.quizletclone.core.utilities.results.SuccessDataResult;
import com.burra.quizletclone.core.utilities.results.SuccessResult;
import com.burra.quizletclone.dataAccess.abstracts.CardsetRepository;
import com.burra.quizletclone.entities.concretes.Card;
import com.burra.quizletclone.entities.concretes.Cardset;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class CardsetManager implements CardsetService {

  private CardsetRepository cardsetRepository;
  private CardService cardService;

  public CardsetManager(CardsetRepository cardsetRepository, CardService cardService) {
    this.cardsetRepository = cardsetRepository;
    this.cardService = cardService;
  }

  @Override
  public DataResult<ArrayList<CardsetGetAllResponse>> getAll() {
    ArrayList<Cardset> cardsets = (ArrayList<Cardset>) cardsetRepository.findAll();
    ArrayList<CardsetGetAllResponse> response = new ArrayList<CardsetGetAllResponse>();

    for (Cardset cardset : cardsets) {
      response.add(CardsetGetAllResponse.FromEntity(cardset));
    }

    return new SuccessDataResult<ArrayList<CardsetGetAllResponse>>(
      response,
      "Setler listelendi."
    );
  }

  @Override
  public DataResult<CardsetGetByIdResponse> getById(int cardsetId) {
    Cardset cardset = cardsetRepository.getReferenceById(cardsetId);
    CardsetGetByIdResponse response = CardsetGetByIdResponse.FromEntity(
      cardset
    );
    return new SuccessDataResult<CardsetGetByIdResponse>(response);
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

  @Override
  @Transactional
  public DataResult<CardsetUpdateResponse> update(
    CardsetUpdateRequest request,
    int cardsetId
  ) {
    Cardset cardset = cardsetRepository.getReferenceById(cardsetId);
    cardset.setName(request.getName());

    ArrayList<Card> oldCards = (ArrayList<Card>) cardset.getCards();
    for(Card card : oldCards) {
      cardService.delete(card.getId());
    }

    ArrayList<CardCreateRequest> newCardsData = (ArrayList<CardCreateRequest>) request.getCards();
    
    for(CardCreateRequest cardData : newCardsData) {
      Card newCard = new Card();
      newCard.setDefinition(cardData.getDefinition());
      newCard.setTerm(cardData.getTerm());
      cardset.addCard(newCard);
    }

    Cardset updatedCardset = cardsetRepository.save(cardset);

    CardsetUpdateResponse response = CardsetUpdateResponse.FromEntity(
      updatedCardset
    );
    return new SuccessDataResult<CardsetUpdateResponse>(response);
  }
}
