package com.burra.quizletclone.business.services.concretes;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.burra.quizletclone.business.services.abstracts.CardService;
import com.burra.quizletclone.core.utilities.results.DataResult;
import com.burra.quizletclone.core.utilities.results.SuccessDataResult;
import com.burra.quizletclone.dataAccess.abstracts.CardRepository;
import com.burra.quizletclone.entities.concretes.Card;

@Service
public class CardManager implements CardService{

  CardRepository cardRepository;

  public CardManager(CardRepository cardRepository) {
    this.cardRepository = cardRepository;
  }

	@Override
	public DataResult<ArrayList<Card>> getAll() {
    ArrayList<Card> cards= (ArrayList<Card>) cardRepository.findAll();
		return new SuccessDataResult<ArrayList<Card>>(cards);
	}
  
}
