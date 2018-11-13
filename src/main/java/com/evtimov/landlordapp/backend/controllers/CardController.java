package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.models.Card;
import com.evtimov.landlordapp.backend.services.base.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {


    private final CardService service;

    @Autowired
    public CardController(CardService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Card addCard(@RequestBody @Valid Card card){
        return service.addCard(card);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<Card> getAllCardsByUserId(@PathVariable(value = "userId") int userId){
        return service.getAllCardsByUserId(userId);
    }

    @RequestMapping(value = "/update/balance/{cardId}", method = RequestMethod.PUT)
    public Card updateCardBalance(@PathVariable(value = "cardId") int cardId, @RequestBody Card card){
        return service.updateCardBalance(cardId, card);
    }
}
