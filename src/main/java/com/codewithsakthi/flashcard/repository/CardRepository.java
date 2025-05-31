package com.codewithsakthi.flashcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsakthi.flashcard.entity.Card;
import com.codewithsakthi.flashcard.entity.Deck;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByDeck(Deck deck);
}
