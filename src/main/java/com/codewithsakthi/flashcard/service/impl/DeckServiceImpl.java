package com.codewithsakthi.flashcard.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithsakthi.flashcard.entity.Deck;
import com.codewithsakthi.flashcard.repository.DeckRepository;
import com.codewithsakthi.flashcard.service.DeckService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeckServiceImpl implements DeckService{

    private final DeckRepository deckRepository;

    @Override
    public Deck createDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    @Override
    public List<Deck> getAllDecks() {
        return deckRepository.findAll();
    }
    
}
