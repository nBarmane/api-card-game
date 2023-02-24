package com.atexotest.apicardgame.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static com.atexotest.apicardgame.service.impl.CardServiceImpl.getTypeOrder;

@Getter
@Setter
@EqualsAndHashCode
public class Card implements Comparable {
    private int value;
    private String type;

    @Override
    public int compareTo(Object o) {
        Card card = (Card) o;

        int orderOfThis = getTypeOrder(this.getType());
        int orderOfOther = getTypeOrder(card.getType());

        if(orderOfThis == orderOfOther) {
            if(this.getValue() == card.getValue())
                return 0;
            return this.getValue() > card.getValue() ? 1 : -1;
        }
        return orderOfThis > orderOfOther ? 1 : -1;
    }
}
