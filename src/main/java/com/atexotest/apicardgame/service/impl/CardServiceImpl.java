package com.atexotest.apicardgame.service.impl;

import com.atexotest.apicardgame.models.Hand;
import com.atexotest.apicardgame.models.Card;
import com.atexotest.apicardgame.service.CardService;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CardServiceImpl implements CardService {
    public static final List<Integer> values = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13);
    public static final List<String> types = List.of("carreau", "pique", "coeur", "trefle");

    private final Set<Card> deckOfCards = new HashSet<>();

    CardServiceImpl() {
        for (String type : types) {
            for (int value : values) {
                Card card = new Card();
                card.setType(type);
                card.setValue(value);
                deckOfCards.add(card);
            }
        }
    }

    public static int getTypeOrder(String type) {
        return types.indexOf(type);
    }

    public Hand getRandomHandAndSortIt(int numberOfCards) {
        List<Card> setOfCards = new ArrayList<>();

        if(numberOfCards>0) {
            numberOfCards = Math.min(numberOfCards, 52);

            List<Card> deckOfCardsShuffeled = new ArrayList<>(deckOfCards);
            Collections.shuffle(deckOfCardsShuffeled);

            setOfCards = new ArrayList<>(deckOfCardsShuffeled.subList(0, numberOfCards));
        }

        List<Card> cardsSorted = new ArrayList<>(setOfCards.stream().toList());
        cardsSorted.sort(Card::compareTo);

        Hand hand = new Hand();
        hand.setCards(setOfCards);
        hand.setSortedCards(cardsSorted);

        return hand;
    }
}
