package com.codewithsakthi.flashcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsakthi.flashcard.entity.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {

}
