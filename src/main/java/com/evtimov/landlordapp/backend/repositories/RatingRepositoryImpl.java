package com.evtimov.landlordapp.backend.repositories;

import com.evtimov.landlordapp.backend.models.Rating;
import com.evtimov.landlordapp.backend.repositories.base.RatingRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingRepositoryImpl implements RatingRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public RatingRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Rating addVote(Rating rating) {

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(rating);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }

        return rating;
    }

    @Override
    public List<Rating> getRatingsByUserId(int userId) {
        List<Rating> ratings;
        String statement = "from Rating where voteFor = :pattern ";

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("pattern", userId);
            ratings = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return ratings;
    }

    @Override
    public Rating isVotedTwoTimes(int voteForId, int voteFromId) {

        List<Rating> ratings;
        String statement = "from Rating where voteFor = :pattern and voteFrom = :pattern2 ";

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("pattern", voteForId);
            query.setParameter("pattern2", voteFromId);
            ratings = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        if(ratings.size() > 0){
            return null;
        }else{
            return new Rating();
        }
    }
}
