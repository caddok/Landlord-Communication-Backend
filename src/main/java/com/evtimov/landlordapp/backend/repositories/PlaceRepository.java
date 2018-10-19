package com.evtimov.landlordapp.backend.repositories;


import com.evtimov.landlordapp.backend.models.Place;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlaceRepository {


    private final SessionFactory sessionFactory;

    @Autowired
    public PlaceRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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

    public Place deletePlaceById(int placeId) {
        Place place = null;

        try(
                Session session = sessionFactory.openSession();
        )
        {
            session.beginTransaction();
            place = session.get(Place.class, placeId);
            session.delete(place);
            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return place;
    }


    // we don;t need it, we will use user.getAllPlaces() from User class
    public void getAllByUserId(int id) {

    }
}
