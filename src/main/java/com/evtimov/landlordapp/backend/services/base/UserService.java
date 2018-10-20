package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.User;

import java.util.List;

public interface UserService {

    User registerUser(User entity);

    List<User> findAllTenants();

    List<User> findAllLandlords();

    User updateUserData(int userId, User model);

    User findUserByUsername(String pattern);

    List<User> findUserByRating(String pattern);

}
