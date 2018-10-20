package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.Place;
import com.evtimov.landlordapp.backend.repositories.base.PlaceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlaceRepositoryImpl implements PlaceRepository {


    private final SessionFactory sessionFactory;

    @Autowired
    public PlaceRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Place addPlace(Place place) {
        try(
                Session session = sessionFactory.openSession();
        )
        {
            session.beginTransaction();
            session.save(place);
            session.getTransaction().commit();
        }catch(Exception ex){

            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return place;
    }


    @Override
    public List<Place> getAllByTenantId(int tenantId) {

        List<Place> places = new ArrayList<>();

        return null;
    }

    @Override
    public List<Place> getAllByLandlordId(int landlordId) {

        List<Place> places = new ArrayList<>();

        return null;
    }
}
