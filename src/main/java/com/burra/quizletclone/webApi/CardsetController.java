package com.burra.quizletclone.webApi;

import com.burra.quizletclone.business.requests.cardsets.CardsetCreateRequest;
import com.burra.quizletclone.business.requests.cardsets.CardsetUpdateRequest;
import com.burra.quizletclone.business.services.abstracts.CardsetService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cardsets")
public class CardsetController {

  private CardsetService cardsetService;

  public CardsetController(CardsetService cardsetService) {
    this.cardsetService = cardsetService;
  }

  @GetMapping("/getAll")
  public ResponseEntity<Result> getAll() {
    Result result = cardsetService.getAll();
    return ResponseEntity.ok(result);
  }

  @PostMapping("/create")
  public ResponseEntity<Result> create(
    @Valid @RequestBody CardsetCreateRequest request
  ) {
    Result result = cardsetService.create(request);

    return ResponseEntity.ok(result);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Result> delete(@PathVariable int id) {
    Result result = cardsetService.delete(id);

    return ResponseEntity.ok(result);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Result> update(
    @PathVariable @Exists(table = "cards") int id,
    @RequestBody CardsetUpdateRequest request
  ) {
    Result result = cardsetService.update(request, id);

    return ResponseEntity.ok(result);
  }
}
