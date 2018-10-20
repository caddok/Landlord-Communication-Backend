package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.Rent;
import com.evtimov.landlordapp.backend.repositories.base.RentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentRepositoryImpl implements RentRepository {


    private final SessionFactory sessionFactory;

    @Autowired
    public RentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
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

    @Override
    public Rent updateRent(int rentId, Rent model) {

        Rent rentToChange;
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
