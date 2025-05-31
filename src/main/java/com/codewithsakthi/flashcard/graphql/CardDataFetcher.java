package com.codewithsakthi.flashcard.graphql;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.dataloader.DataLoader;

import com.codewithsakthi.flashcard.entity.Card;
import com.codewithsakthi.flashcard.service.CardService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;

import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class CardDataFetcher {

    private final CardService cardService;

    @DgsQuery
    public List<Card> cards(Long deckId) throws Exception {
        return cardService.getCardsByDeckId(deckId);
    }

    @DgsData(parentType = "Deck", field = "cards")
    public CompletableFuture<List<Card>> cards(DataFetchingEnvironment dfe) {
          DataLoader<Long, List<Card>> dataLoader = dfe.getDataLoader("cards");
          Long deckId = dfe.getArgument("ids");
          return dataLoader.load(deckId);
      }

    @DgsMutation
    public Card addCard(Long deckId, String question, String answer) throws Exception {
        return cardService.addCard(deckId, question, answer);
    }

}
