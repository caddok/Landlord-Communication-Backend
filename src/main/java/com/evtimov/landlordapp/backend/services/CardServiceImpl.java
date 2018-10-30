package com.evtimov.landlordapp.backend.services;
import com.evtimov.landlordapp.backend.models.Card;
import com.evtimov.landlordapp.backend.repositories.base.CardRepository;
import com.evtimov.landlordapp.backend.services.base.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository repository;

    @Autowired
    public CardServiceImpl(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public Card addCard(Card card) {
        repository.addCard(card);
        return card;
    }

    @Override
    public List<Card> getAllCardsByUserId(int userId) {
        return repository.getAllCardsByUserId(userId);
    }

    @Override
    public Card updateCardBalance(int cardId, Card card) {
        return repository.updateCardBalance(cardId, card);
    }
}

