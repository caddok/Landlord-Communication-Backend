package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.Message;
import com.evtimov.landlordapp.backend.repositories.base.MessageRepository;
import com.evtimov.landlordapp.backend.utils.DateProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepository {
    private final SessionFactory sessionFactory;
    private final DateProvider dateProvider;


    @Autowired
    public MessageRepositoryImpl(SessionFactory sessionFactory, DateProvider dateProvider) {
        this.sessionFactory = sessionFactory;
        this.dateProvider = dateProvider;
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

/*    @Override
    public List<Message> getAllDeliveredMessagesByTenantId(int tenantId) {

        Date date = dateProvider.getDateBeforeThreeMonths();

        List<Message> messages;
        String statement = "from Message where tenantID = :idPattern and isDelivered = :deliveredPattern " +
                "and timestamp >= :datePattern ";

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("idPattern", tenantId);
            query.setParameter("deliveredPattern", true);
            query.setParameter("datePattern", date);
            messages = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return messages;
    }

    @Override
    public List<Message> getAllUndeliveredMessagesByTenantId(int tenantId) {

        Date date = dateProvider.getDateBeforeThreeMonths();
        List<Message> messages;
        String statement = "from Message where tenantID = :idPattern and isDelivered = :deliveredPattern " +
                "and timestamp >= :datePattern ";

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("idPattern", tenantId);
            query.setParameter("deliveredPattern", false);
            query.setParameter("datePattern", date);
            messages = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return messages;
    }

    @Override
    public List<Message> getAllDeliveredMessagesByLandlordId(int landlordId) {
        Date date = dateProvider.getDateBeforeThreeMonths();
        List<Message> messages;
        String statement = "from Message where landlordID = :idPattern and isDelivered = :deliveredPattern " +
                "and timestamp >= :datePattern ";

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("idPattern", landlordId);
            query.setParameter("deliveredPattern", true);
            query.setParameter("datePattern", date);
            messages = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return messages;
    }

    @Override
    public List<Message> getAllUndeliveredMessagesByLandlordId(int landlordId) {
        Date date = dateProvider.getDateBeforeThreeMonths();
        List<Message> messages;
        String statement = "from Message where landlordID = :idPattern and isDelivered = :deliveredPattern " +
                "and timestamp >= :datePattern ";

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("idPattern", landlordId);
            query.setParameter("deliveredPattern", false);
            query.setParameter("datePattern", date);
            messages = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return messages;
    }*/
}
