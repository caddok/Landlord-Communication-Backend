package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.ChatSession;
import com.evtimov.landlordapp.backend.repositories.base.ChatSessionRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import java.util.List;

@Repository
public class ChatSessionRepositoryImpl implements ChatSessionRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public ChatSessionRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<ChatSession> getAllByTenantId(int tenantId) {
        List<ChatSession> chats;
        String pattern = String.valueOf(tenantId);
        String statement = "from ChatSession where tenantID = :pattern ";  // ChatSession is the pojo class, tenantID is field in the class

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("pattern", pattern);
            chats = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return chats;
    }

    @Override
    public List<ChatSession> getAllByLandlordId(int landlordId) {
        List<ChatSession> chats;
        String pattern = String.valueOf(landlordId);
        String statement = "from ChatSession where landlordID = :pattern ";  // ChatSession is the pojo class, landlordID is field in the class

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("pattern", pattern);
            chats = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return chats;
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
    public ChatSession deleteChat(int chatId) {

        ChatSession chat;

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
