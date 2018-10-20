package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.Payment;
import com.evtimov.landlordapp.backend.repositories.base.PaymentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        return null;
    }
}
