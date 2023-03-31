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
import com.burra.quizletclone.dataAccess.abstracts.CardRepository;
import com.burra.quizletclone.dataAccess.abstracts.CardsetRepository;
import com.burra.quizletclone.entities.concretes.Card;
import com.burra.quizletclone.entities.concretes.Cardset;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CardsetManager implements CardsetService {

  private CardsetRepository cardsetRepository;
  private CardRepository cardRepository;
  private CardService cardService;

  public CardsetManager(CardsetRepository cardsetRepository, CardRepository cardRepository, CardService cardService) {
    this.cardsetRepository = cardsetRepository;
    this.cardRepository = cardRepository;
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
    Cardset cardset = cardsetRepository.findById(cardsetId).get();
    cardset.setName(request.getName());

    List<Card> oldCards = cardset.getCards();

    for(Card card : oldCards) {
      cardRepository.delete(card);
    }
    oldCards.clear();

    ArrayList<CardCreateRequest> newCardsData = (ArrayList<CardCreateRequest>) request.getCards();
    
    for(CardCreateRequest cardData : newCardsData) {
      Card newCard = new Card();
      newCard.setDefinition(cardData.getDefinition());
      newCard.setTerm(cardData.getTerm());
      newCard.setCardset(cardset);
      cardset.addCard(newCard);
    }

    Cardset updatedCardset = cardsetRepository.save(cardset);

    for(Card card : updatedCardset.getCards()) {
      System.out.println(card.getDefinition() + "--" + card.getTerm());
    }
    CardsetUpdateResponse response = CardsetUpdateResponse.FromEntity(
      updatedCardset
    );

    return new SuccessDataResult<CardsetUpdateResponse>(response);
  }
}
