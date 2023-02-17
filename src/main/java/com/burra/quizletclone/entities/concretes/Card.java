package com.burra.quizletclone.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "cardset_id", nullable = false)
  @JsonBackReference
  private Cardset cardset;

  @Column(name = "definition")
  private String definition;

  @Column(name = "term")
  private String term;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Cardset getCardset() {
    return cardset;
  }

  public void setCardset(Cardset cardset) {
    this.cardset = cardset;
  }

  public String getDefinition() {
    return definition;
  }

  public void setDefinition(String definition) {
    this.definition = definition;
  }

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }
}
