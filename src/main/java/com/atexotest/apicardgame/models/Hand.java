package com.atexotest.apicardgame.models;

import com.atexotest.apicardgame.models.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class Hand {
    Collection<Card> cards;
    Collection<Card> sortedCards;
}
