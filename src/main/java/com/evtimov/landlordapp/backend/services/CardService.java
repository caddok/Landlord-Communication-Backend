package com.evtimov.landlordapp.backend.services;
import com.evtimov.landlordapp.backend.models.Card;
import com.evtimov.landlordapp.landlordspring.models.Card;
import com.evtimov.landlordapp.landlordspring.repositories.base.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {
    private final CardRepository repository;

    @Autowired
    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public void addCard(Card card) {
        repository.save(card);
    }

    public void deleteCard(Card entity){
        repository.delete(entity);
    }

    public List<Card> getAllCardsByUser(int id) {
        List<Card> allCards = (List<Card>) repository.findAll();
        return allCards.stream()
                .filter(c -> c.getUserID() == id)
                .collect(Collectors.toList());
    }


}

