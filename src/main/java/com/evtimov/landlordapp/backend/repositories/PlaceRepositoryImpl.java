package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.Place;
import com.evtimov.landlordapp.backend.repositories.base.PlaceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

        List<Place> places;
        String pattern = String.valueOf(tenantId);
        String statement = "from Place where tenantID = :pattern ";  // Place is the pojo class, tenantID is field in the class

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("tenantID", pattern);
            places = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return places;
    }

    @Override
    public List<Place> getAllByLandlordId(int landlordId) {

        List<Place> places;
        String pattern = String.valueOf(landlordId);
        String statement = "from Place where landlordID = :pattern ";  // Place is the pojo class, landlordID is field in the class

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("landlordID", pattern);
            places = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return places;
    }
}
