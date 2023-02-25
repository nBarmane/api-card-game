package com.atexotest.apicardgame.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class Hand {
    Collection<Card> cards;
    Collection<Card> sortedCards;
}
