package com.codewithsakthi.flashcard.graphql;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.dataloader.BatchLoader;

import com.codewithsakthi.flashcard.entity.Card;
import com.codewithsakthi.flashcard.service.CardService;
import com.netflix.graphql.dgs.DgsDataLoader;

import lombok.RequiredArgsConstructor;

@DgsDataLoader(name = "cards")
@RequiredArgsConstructor
public class CardsDataLoader implements BatchLoader<Long, Card> {

    private final CardService cardService;

    @Override
    public CompletionStage<List<Card>> load(List<Long> keys) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return cardService.getCardsByIds(keys);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        });
    }

}
