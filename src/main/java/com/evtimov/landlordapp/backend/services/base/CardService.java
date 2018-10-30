package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Card;

import java.util.List;

public interface CardService {

    Card addCard(Card card);

    List<Card> getAllCardsByUserId(int userId);

    Card updateCardBalance(int cardId, Card card);
}
