package com.evtimov.landlordapp.backend.services;


import com.evtimov.landlordapp.backend.models.User;
import com.evtimov.landlordapp.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User registerUser(User user) {
        repository.save(user);
        return user;
    }

    //Under question; must ask the clients
    public void deleteUser(int id){}

    public List<User> findAllTenants(){
        List<User> allUsers = (List<User>) repository.findAll();
        return allUsers.stream()
                .filter(user -> !user.getIsLandlord())
                .collect(Collectors.toList());
    }

    public List<User> findAllLandlords(){
        List<User> allUsers = (List<User>) repository.findAll();
        return allUsers.stream()
                .filter(User::getIsLandlord)
                .collect(Collectors.toList());
    }

    public Optional<User> findUserByUsername(int pattern){
        List<User> allUsers = (List<User>) repository.findAll();
        return allUsers.stream()
                .filter(user -> user.getUserID() == pattern)
                .findFirst();
    }

    public List<User> findUsersByRating(String pattern){
        int ratingAsNumber = Integer.parseInt(pattern);
        List<User> allUsers = (List<User>) repository.findAll();
        return allUsers.stream()
                .filter(user -> user.getRating() == ratingAsNumber)
                .collect(Collectors.toList());
    }

    public User updateUserData(User user){
        repository.save(user);
        return user;
    }
}

