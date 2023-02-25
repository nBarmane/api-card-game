package com.atexotest.apicardgame.controller;

import com.atexotest.apicardgame.models.Hand;
import com.atexotest.apicardgame.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card-game/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("get-hand")
    public Hand getHand(@RequestParam("numberOfCards") int numberOfCards) {
        return cardService.getRandomHandAndSortIt(numberOfCards);
    }
}
