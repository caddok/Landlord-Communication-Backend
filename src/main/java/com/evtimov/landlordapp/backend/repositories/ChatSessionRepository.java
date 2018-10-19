package com.evtimov.landlordapp.backend.repositories;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatSessionRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public ChatSessionRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    // we don't need it, cause we will user user.getAllChatSessions()
    public List<ChatSession> getAllByUserId(int id) {
        return null;
    }

    public ChatSession createSession(ChatSession chat){

        try(
                Session session = sessionFactory.openSession();
                )
        {
            session.beginTransaction();
            session.save(chat);
            session.getTransaction().commit();
        }catch(Exception ex){

            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return chat;
    }

    public ChatSession deleteUselessSession(int id) {

        ChatSession chat = null;

        try(
                Session session = sessionFactory.openSession();
                )
        {
            session.beginTransaction();
            chat = session.get(ChatSession.class, id);
            session.delete(chat);
            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return chat;
    }
}
