package com.burra.quizletclone.webApi;

import com.burra.quizletclone.business.requests.cards.CardCreateRequest;
import com.burra.quizletclone.business.services.abstracts.CardService;
import com.burra.quizletclone.core.utilities.results.Result;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

  @PostMapping("/create")
  public ResponseEntity<Result> create(@Valid @RequestBody CardCreateRequest request) {
    Result result = cardService.create(request);

    return ResponseEntity.ok(result);
  }
}
