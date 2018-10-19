package com.evtimov.landlordapp.backend.repositories;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public PaymentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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


    //we don't need it, we will use user.getAllPayments() from User class
    public List<Payment> getAllPaymentsByUserId(int id){
        return null;
    }
}
