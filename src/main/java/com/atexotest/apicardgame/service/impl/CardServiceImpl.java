package com.atexotest.apicardgame.service.impl;

import com.atexotest.apicardgame.models.Hand;
import com.atexotest.apicardgame.models.Card;
import com.atexotest.apicardgame.service.CardService;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CardServiceImpl implements CardService {
    public static final List<Integer> values = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13);
    public static final List<String> types = List.of("carreau", "coeur", "pique", "trefle");
    public static int getTypeOrder(String type) {
        return types.indexOf(type);
    }
    public Hand getRandomHandAndSortIt(int numberOfCards) {
        Set<Card> setOfCards = new HashSet<>();

        while(setOfCards.size()<numberOfCards) {
            int randomValueIndex = (int) (Math.random() * values.size());
            int randomTypeIndex = (int) (Math.random() * types.size());

            Card card = new Card();
            card.setValue(values.get(randomValueIndex));
            card.setType(types.get(randomTypeIndex));

            setOfCards.add(card);
        }

        List<Card> cardsSorted = new ArrayList<>(setOfCards.stream().toList());
        cardsSorted.sort(Card::compareTo);

        Hand hand = new Hand();
        hand.setCards(setOfCards);
        hand.setSortedCards(cardsSorted);

        return hand;
    }
}
