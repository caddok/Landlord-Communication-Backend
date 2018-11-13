package com.evtimov.landlordapp.backend.services;


import com.evtimov.landlordapp.backend.models.User;
import com.evtimov.landlordapp.backend.repositories.base.UserRepository;
import com.evtimov.landlordapp.backend.services.base.UserService;
import com.evtimov.landlordapp.backend.utils.Constants;
import com.evtimov.landlordapp.backend.utils.password.PasswordAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordAgent passwordAgent;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordAgent passwordAgent) {
        this.repository = repository;
        this.passwordAgent = passwordAgent;
    }

    @Override
    public User registerUser(User entity) {

        return repository.registerUser(entity);
    }


    @Override
    public List<User> findAllTenants(){
        return repository.findAllTenants();
    }

    @Override
    public List<User> findAllLandlords(){
        return repository.findAllLandlords();
    }

    @Override
    public User findUserByUsername(String pattern){
        List<User> users =  repository.getUserByUsername(pattern);

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }


    @Override
    public User checkUsername(String pattern) {
        List<User> users = repository.checkUsername(pattern);
        String username;
        if (users.size() > 0) {
            username = Constants.USED;
        } else {
            username = Constants.FREE;
        }

        User userModel = new User(false, username, null, null, null,
                null, false, null, null);

        return userModel;
    }

    @Override
    public User checkEmail(String pattern) {
        List<User> users =  repository.checkEmail(pattern);
        String email;

        if (users.size() > 0) {
            email = Constants.USED;
        } else {
            email = Constants.FREE;
        }

        User userModel = new User(false, null, null, null, null,
                email, false, null, null);

        return userModel;
    }

    @Override
    public User getUserById(int userId) {

        User incoming = repository.getUserById(userId);

        // cause we don't want to send the whole user info
        User sending = new User(incoming.getIsLandlord(), incoming.getUsername(), incoming.getPicture(), incoming.getFirstName(), incoming.getLastName(),
                incoming.getEmail(), incoming.getIsOnline(), null, null);
        sending.setUserId(userId);

        return sending;
    }


    @Override
    public User updateUserOnlineStatus(int userId, User model){
        return repository.updateUserOnlineStatus(userId, model);
    }

    @Override
    public User getUserHashAndSaltByUsername(String username){
        List<User> users = repository.getUserHashAndSaltByUsername(username);
        User model;

        if (users.size() > 0) {
            model = new User(users.get(0).getPasswordHash(), users.get(0).getPasswordSalt());
            return model;
        }else{
            return null;
        }
    }
}
