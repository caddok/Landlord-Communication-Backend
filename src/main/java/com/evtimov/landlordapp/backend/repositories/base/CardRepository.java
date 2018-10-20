package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.Card;

import java.util.List;

public interface CardRepository {

    Card addCard(Card card);

    Card removeCard(int cardId);

    List<Card> getAllCardsByUser(int userId);
}
