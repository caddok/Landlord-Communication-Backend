package com.evtimov.landlordapp.backend.repositories;

import com.evtimov.landlordapp.backend.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    final
    SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public User registerUser(User entity){
        try(
                Session session = sessionFactory.openSession();
                )
        {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }

        return entity;
    }

    public User deleteUser(int userId){

        User entity = null;
        try(
                Session session = sessionFactory.openSession();
                )
        {
            session.beginTransaction();
            entity = session.get(User.class, userId);
            session.delete(entity);
            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }

        return entity;
    }

    public List<User> findAllTenants(){



        return ;
    }

    public List<User> findAllLandlords(){



        return ;
    }


    public User updateUserData(int userId, User model){
        User userToChange = null;
        try(
                Session session = sessionFactory.openSession();
                )
        {
            session.beginTransaction();
            userToChange = session.get(User.class, userId);

            //update user

            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }

        return userToChange;
    }

    public User getUserByUsername(String pattern){
        List<User> users = new ArrayList<>();
        String statement = "from User where username = :pattern ";  // User is the pojo class, username is field in the class

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("username", pattern);
            users = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return users.get(0);
    }

    public List<User> findUsersByRating(String pattern){
        List<User> users = new ArrayList<>();
        String statement = "from User where rating = :pattern ";

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("rating", pattern);
            users = query.list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return users;
    }



    private List<User> getAll(){
        List<User> users = new ArrayList<>();

        try(
                Session session = sessionFactory.openSession();
                )
        {
            session.beginTransaction();
            users = session.createQuery("from User").list();
            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return users;
    }
}
