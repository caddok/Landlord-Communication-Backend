package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Card;

import java.util.List;

public interface CardService {

    Card addCard(Card card);

    void removeCard(int cardId);

    List<Card> getAllCardsByUserId(int userId);
}
