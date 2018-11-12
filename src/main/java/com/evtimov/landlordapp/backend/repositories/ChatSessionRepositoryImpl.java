package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.ChatSession;
import com.evtimov.landlordapp.backend.repositories.base.ChatSessionRepository;
import com.evtimov.landlordapp.backend.utils.Constants;
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
        String statement = "from ChatSession where tenantID = :pattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter(Constants.PATTERN, tenantId);
            chats = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return chats;
    }

    @Override
    public List<ChatSession> checkIfChatSessionExistsByTenantIdAndLandlordId(int tenantId, int landlordId) {
        List<ChatSession> chats;
        String statement = "from ChatSession where landlordID = :patternLandlord and tenantID = :patternTenant ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter(Constants.PATTERN_LANDLORD, landlordId);
            query.setParameter(Constants.TENANT_PATTERN, tenantId);
            chats = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return chats;
    }

    @Override
    public List<ChatSession> getAllByLandlordId(int landlordId) {
        List<ChatSession> chats;
        String statement = "from ChatSession where landlordID = :pattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter(Constants.PATTERN, landlordId);
            chats = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return chats;
    }

    @Override
    public ChatSession createSession(ChatSession chat) {

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(chat);
            session.getTransaction().commit();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return chat;
    }
}
