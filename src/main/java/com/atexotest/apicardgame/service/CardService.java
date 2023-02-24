package com.atexotest.apicardgame.service;

import com.atexotest.apicardgame.models.Hand;
import org.springframework.stereotype.Service;

@Service
public interface CardService {
    Hand getRandomHandAndSortIt(int numberOfCards);
}
