package com.codewithsakthi.flashcard.service;

import java.util.List;

import com.codewithsakthi.flashcard.entity.Card;

public interface CardService {
    public List<Card> getCardsByDeckId(Long deckId) throws Exception;
    public List<Card> getCardsByIds(List<Long> ids) throws Exception;
    public Card addCard(Long deckId, String question, String answer) throws Exception;
}
