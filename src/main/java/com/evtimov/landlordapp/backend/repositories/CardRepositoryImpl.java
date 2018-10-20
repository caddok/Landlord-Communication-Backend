package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.Card;
import com.evtimov.landlordapp.backend.repositories.base.CardRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public CardRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Card addCard(Card card){

        try(
                Session session = sessionFactory.openSession();
        )
        {
            session.beginTransaction();
            session.save(card);
            session.getTransaction().commit();
        }catch(Exception ex){

            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return card;
    }

    @Override
    public Card removeCard(int cardId) {

        Card card = null;

        try(
                Session session = sessionFactory.openSession();
        )
        {
            session.beginTransaction();
            card = session.get(Card.class, cardId);
            session.delete(card);
            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return card;
    }


    @Override
    public List<Card> getAllCardsByUserId(int userId) {
        return null;
    }
}
