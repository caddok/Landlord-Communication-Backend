package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.Rent;
import com.evtimov.landlordapp.backend.repositories.base.RentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentRepositoryImpl implements RentRepository {


    private final SessionFactory sessionFactory;

    @Autowired
    public RentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Rent addRent(Rent rent) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(rent);
            session.getTransaction().commit();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return rent;
    }

    @Override
    public Rent updateRentRemaining(int rentId, Rent rent) {

        Rent rentToChange;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            rentToChange = session.get(Rent.class, rentId);

            rentToChange.setRemaining(rent.getRemaining());

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }

        return rentToChange;
    }

    @Override
    public Rent updateRentIsPaidStatus(int rentId) {

        Rent rentToChange;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            rentToChange = session.get(Rent.class, rentId);

            rentToChange.setIsPaid(true);
            rentToChange.setRemaining(0);

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }

        return rentToChange;
    }

    @Override
    public Rent getRentByPlaceId(int placeId) {
        List<Rent> rents;
        String statement = "from Rent where placeID = :pattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("pattern", placeId);
            rents = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        if (rents.size() > 0) {
            return rents.get(0);
        } else {
            return null;
        }
    }
}
