package com.evtimov.landlordapp.backend.repositories;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public CardRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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


        //we don't need it, we will use user.getAllCards()
    public List<Card> getAllCardsByUser(int id) {
        return null;
    }
}
