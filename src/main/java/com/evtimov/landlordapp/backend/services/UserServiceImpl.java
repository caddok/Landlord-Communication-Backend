package com.evtimov.landlordapp.backend.services;


import com.evtimov.landlordapp.backend.models.User;
import com.evtimov.landlordapp.backend.repositories.base.UserRepository;
import com.evtimov.landlordapp.backend.services.base.UserService;
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

    public User registerUser(User entity) {
        repository.registerUser(entity);
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
        return repository.getUserByUsername(pattern);
    }


    @Override
    public String checkUsername(String pattern) {
        return repository.checkUsername(pattern);
    }

    @Override
    public String checkEmail(String pattern) {
        return repository.checkEmail(pattern);
    }


    @Override
    public User updateUserOnlineStatus(int userId, User model){
        repository.updateUserOnlineStatus(userId, model);
        return model;
    }

    @Override
    public User getUserHashAndSaltByUsername(String username){
        return repository.getUserHashAndSaltByUsername(username);
    }
}

