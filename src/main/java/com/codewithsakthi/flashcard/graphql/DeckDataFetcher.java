package com.codewithsakthi.flashcard.graphql;

import java.util.List;

import com.codewithsakthi.flashcard.entity.Deck;
import com.codewithsakthi.flashcard.service.DeckService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;

import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class DeckDataFetcher {

    private final DeckService deckService;

    @DgsQuery
    public List<Deck> decks() {
        return deckService.getAllDecks();
    }

    @DgsMutation
    public Deck createDeck(String name) {
        Deck deck = Deck.builder()
                .name(name)
                .build();
        return deckService.createDeck(deck);
    }

}
