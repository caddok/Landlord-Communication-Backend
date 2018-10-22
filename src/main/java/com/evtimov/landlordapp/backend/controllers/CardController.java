package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.models.Card;
import com.evtimov.landlordapp.backend.services.base.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                                  //CHECKED
@RequestMapping("/api/cards")
public class CardController {


    private final CardService service;

    @Autowired
    public CardController(CardService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Card addCard(@RequestBody Card card){
        service.addCard(card);

        return card;
    }

    @RequestMapping(value = "/{cardId}", method = RequestMethod.DELETE)
    public void removeCard(@PathVariable(value = "cardId") int cardId){
        service.removeCard(cardId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<Card> getAllCardsByUserId(@PathVariable(value = "userId") int userId){
        return service.getAllCardsByUserId(userId);
    }
}
