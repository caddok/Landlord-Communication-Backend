package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.Payment;
import com.evtimov.landlordapp.backend.repositories.base.PaymentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public PaymentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Payment payYourBill(Payment payment) {
        try(
                Session session = sessionFactory.openSession();
        )
        {
            session.beginTransaction();
            session.save(payment);
            session.getTransaction().commit();
        }catch(Exception ex){

            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return payment;
    }


    @Override
    public List<Payment> getAllPaymentsByUserId(int userId){

        List<Payment> payments;
        String pattern = String.valueOf(userId);
        String statement = "from Payment where userID = :pattern ";  // Payment is the pojo class, userID is field in the class

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("pattern", pattern);
            payments = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return payments;
    }
}
