package com.evtimov.landlordapp.backend.repositories;

import com.evtimov.landlordapp.backend.models.User;
import com.evtimov.landlordapp.backend.repositories.base.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final
    SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public User registerUser(User entity) {

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return entity;
    }


    @Override
    public List<User> findAllTenants() {
        List<User> users;

        users = getAll().stream().filter(u -> !u.getIsLandlord()).collect(Collectors.toList());

        return users;
    }

    @Override
    public List<User> findAllLandlords() {
        List<User> users;

        users = getAll().stream().filter(User::getIsLandlord).collect(Collectors.toList());

        return users;
    }


    @Override
    public User updateUserOnlineStatus(int userId, User model) {

        User userToChange;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            userToChange = session.get(User.class, userId);

            userToChange.setIsOnline(model.getIsOnline());

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return userToChange;
    }

    @Override
    public User getUserByUsername(String pattern) {
        List<User> users;
        String statement = "from User where username = :pattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("pattern", pattern);
            users = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getUserHashAndSaltByUsername(String username) {
        List<User> users;
        User model;
        String statement = "from User where username = :pattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("pattern", username);
            users = query.list();
            if (users.size() > 0) {
                model = new User(users.get(0).getPasswordHash(), users.get(0).getPasswordSalt());
                return model;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public String checkUsername(String pattern) {
        List<User> users;
        String username;
        String statement = "from User where username = :pattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("pattern", pattern);
            users = query.list();
            if (users.size() > 0) {
                username = "used";
            } else {
                username = "free";
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return username;
    }

    @Override
    public String checkEmail(String pattern) {
        List<User> users;
        String email;
        String statement = "from User where email = :pattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter("pattern", pattern);
            users = query.list();
            if (users.size() > 0) {
                email = "used";
            } else {
                email = "free";
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return email;
    }

    @Override
    public User getUserById(int userId) {
        User user;

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            user = session.get(User.class, userId);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return user;
    }

    private List<User> getAll() {
        List<User> users;

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            users = session.createQuery("from User").list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return users;
    }

}
