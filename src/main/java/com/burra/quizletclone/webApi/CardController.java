package com.burra.quizletclone.webApi;

import com.burra.quizletclone.business.requests.cards.CardCreateRequest;
import com.burra.quizletclone.business.requests.cards.CardUpdateRequest;
import com.burra.quizletclone.business.services.abstracts.CardService;
import com.burra.quizletclone.core.annotations.Exists;
import com.burra.quizletclone.core.utilities.results.Result;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardController {

  private CardService cardService;

  public CardController(CardService cardService) {
    this.cardService = cardService;
  }

  @GetMapping
  public ResponseEntity<Result> getAll(
    @RequestParam(required = false) @Exists(table = "cardsets") Long cardsetId
  ) {
    Result result = cardService.getAll(cardsetId);

    return ResponseEntity.ok(result);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Result> getById(@PathVariable int id) {
    Result result = cardService.getById(id);

    return ResponseEntity.ok(result);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Result> delete(@PathVariable int id) {
    Result result = cardService.delete(id);

    return ResponseEntity.ok(result);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Result> update(
    @PathVariable int id,
    @RequestBody CardUpdateRequest request
  ) {
    System.out.println(id);
    Result result = cardService.update(request, id);

    return ResponseEntity.ok(result);
  }
}
