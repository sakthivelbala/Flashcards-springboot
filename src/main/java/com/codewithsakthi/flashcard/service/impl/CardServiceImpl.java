package com.codewithsakthi.flashcard.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codewithsakthi.flashcard.entity.Card;
import com.codewithsakthi.flashcard.entity.Deck;
import com.codewithsakthi.flashcard.repository.CardRepository;
import com.codewithsakthi.flashcard.repository.DeckRepository;
import com.codewithsakthi.flashcard.service.CardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final DeckRepository deckRepository;

    @Override
    public List<Card> getCardsByDeckId(Long deckId) throws Exception {
        Optional<Deck> deck = deckRepository.findById(deckId);
        if (deck.isEmpty()) {
            throw new Exception("No such deck !");
        }
        return cardRepository.findByDeck(deck.get());
    }

    @Override
    public Card addCard(Long deckId, String question, String answer) throws Exception {
        Optional<Deck> deck = deckRepository.findById(deckId);
        if (deck.isEmpty()) {
            throw new Exception("No such deck !");
        }
        Card card = Card.builder().deck(deck.get()).question(question).answer(answer).createdAt(LocalDateTime.now())
                .build();
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getCardsByIds(List<Long> ids) throws Exception {
        return cardRepository.findAllById(ids);
    }

}
