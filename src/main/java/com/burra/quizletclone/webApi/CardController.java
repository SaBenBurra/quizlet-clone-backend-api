package com.burra.quizletclone.webApi;

import com.burra.quizletclone.business.services.abstracts.CardService;
import com.burra.quizletclone.core.utilities.results.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/api/cards")
public class CardController {

  private CardService cardService;

  public CardController(CardService cardService) {
    this.cardService = cardService;
  }

  @GetMapping("/getAll")
  public ResponseEntity<Result> getAll() {
    Result result = cardService.getAll();

    return ResponseEntity.ok(result);
  }
}
