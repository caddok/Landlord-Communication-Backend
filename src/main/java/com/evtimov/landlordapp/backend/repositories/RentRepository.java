package com.evtimov.landlordapp.backend.repositories;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentRepository {


    private final SessionFactory sessionFactory;

    @Autowired
    public RentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Rent addRent(Rent rent) {
        try(
                Session session = sessionFactory.openSession();
        )
        {
            session.beginTransaction();
            session.save(rent);
            session.getTransaction().commit();
        }catch(Exception ex){

            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return rent;
    }

    public Rent updateRent(int rentId, Rent model) {

        Rent rentToChange = null;
        try(
                Session session = sessionFactory.openSession();
        )
        {
            session.beginTransaction();
            rentToChange = session.get(Rent.class, rentId);

            //update rent

            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }

        return rentToChange;
    }

}
