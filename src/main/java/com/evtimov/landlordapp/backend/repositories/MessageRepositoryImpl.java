package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.Message;
import com.evtimov.landlordapp.backend.repositories.base.MessageRepository;
import com.evtimov.landlordapp.backend.utils.Constants;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public MessageRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Message createMessage(Message message) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(message);
            session.getTransaction().commit();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return message;
    }

    @Override
    public List<Message> getMessagesBySenderIdAndChatId(int senderId, int chatId, String date) {

        List<Message> messages;
        String statement = "from Message where senderID = :idPattern and chatSessionID = :chatPattern " +
                "and timestamp >= :datePattern ";

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter(Constants.ID_PATTERN, senderId);
            query.setParameter(Constants.CHAT_PATTERN, chatId);
            query.setParameter(Constants.DATE_PATTERN_HQL, date);
            messages = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return messages;
    }

    @Override
    public List<Message> getMessagesByReceiverIdAndChatId(int receiverId, int chatId, String date) {

        List<Message> messages = null;
        String statement = "from Message where receiverID = :idPattern and chatSessionID = :chatPattern " +
                "and timestamp >= :datePattern ";

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter(Constants.ID_PATTERN, receiverId);
            query.setParameter(Constants.CHAT_PATTERN, chatId);
            query.setParameter(Constants.DATE_PATTERN_HQL, date);
            messages = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return messages;
    }

    @Override
    public List<Message> getMessagesByChatId(int chatId) {
        List<Message> messages = null;
        String statement = "from Message where chatSessionID = :chatPattern";

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter(Constants.CHAT_PATTERN, chatId);
            messages = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return messages;
    }
}