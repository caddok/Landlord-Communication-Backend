package com.evtimov.landlordapp.backend.repositories;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepositoryImpl {

    private final SessionFactory sessionFactory;

    @Autowired
    public MessageRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
