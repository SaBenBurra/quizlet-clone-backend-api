package com.burra.quizletclone.dataAccess.abstracts;

import com.burra.quizletclone.entities.concretes.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {}
