package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.Card;

import java.util.List;

public interface CardRepository {

    Card addCard(Card card);

    List<Card> getAllCardsByUserId(int userId);

    Card updateCardBalance(int cardId, Card card);
}
