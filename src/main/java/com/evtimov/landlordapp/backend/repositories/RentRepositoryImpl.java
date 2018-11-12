package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.Rent;
import com.evtimov.landlordapp.backend.repositories.base.RentRepository;
import com.evtimov.landlordapp.backend.utils.Constants;
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
    public List<Rent> getRentByPlaceId(int placeId) {
        List<Rent> rents;
        String statement = "from Rent where placeID = :pattern and isPaid = :paidPattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter(Constants.PATTERN, placeId);
            query.setParameter(Constants.PAID_PATTERN, false);
            rents = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return rents;
    }

    @Override
    public Rent editRent(Rent rent, int rentId) {
        Rent rentToChange;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            rentToChange = session.get(Rent.class, rentId);
            rentToChange.setRemaining(rent.getRemaining());
            rentToChange.setTotalAmount(rent.getTotalAmount());

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }

        return rentToChange;
    }
}
