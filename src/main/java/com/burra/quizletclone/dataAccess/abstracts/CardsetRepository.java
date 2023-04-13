package com.burra.quizletclone.dataAccess.abstracts;

import com.burra.quizletclone.entities.concretes.Cardset;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsetRepository extends JpaRepository<Cardset, Integer> {
  List<Cardset> findAllByOrderByIdDesc();
}
