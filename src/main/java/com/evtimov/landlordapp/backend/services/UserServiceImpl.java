package com.evtimov.landlordapp.backend.services;


import com.evtimov.landlordapp.backend.models.User;
import com.evtimov.landlordapp.backend.repositories.base.UserRepository;
import com.evtimov.landlordapp.backend.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User registerUser(User entity) {
        entity.setRating(entity.getVoteSum()/entity.getVotes());
        repository.registerUser(entity);
        return entity;
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
    public List<User> findUserByRating(double pattern){
        return repository.findUserByRating(pattern);
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
    public User updateUserRating(int userId, User model){
        repository.updateUserRating(userId, model);
        return model;
    }

    @Override
    public User updateUserOnlineStatus(int userId, User model){
        repository.updateUserOnlineStatus(userId, model);
        return model;
    }

    @Override
    public String updateUserRegistrationToken(int userId, String token) {
        repository.updateUserRegistrationToken(userId,token);
        return token;
    }

}

