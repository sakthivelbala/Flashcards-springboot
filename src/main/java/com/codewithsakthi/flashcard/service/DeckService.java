package com.codewithsakthi.flashcard.service;

import java.util.List;

import com.codewithsakthi.flashcard.entity.Deck;

public interface DeckService {

    public Deck createDeck(Deck deck);

    public List<Deck> getAllDecks();
}
