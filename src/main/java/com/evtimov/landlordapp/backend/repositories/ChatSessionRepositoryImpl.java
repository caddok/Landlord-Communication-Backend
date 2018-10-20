package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.ChatSession;
import com.evtimov.landlordapp.backend.repositories.base.ChatSessionRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatSessionRepositoryImpl implements ChatSessionRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public ChatSessionRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    // we don't need it, cause we will user user.getAllChatSessions()
    @Override
    public List<ChatSession> getAllByUserId(int userId) {
        return null;
    }

    @Override
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

    @Override
    public ChatSession deleteUselessSession(int chatId) {

        ChatSession chat = null;

        try(
                Session session = sessionFactory.openSession();
                )
        {
            session.beginTransaction();
            chat = session.get(ChatSession.class, chatId);
            session.delete(chat);
            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return chat;
    }
}
