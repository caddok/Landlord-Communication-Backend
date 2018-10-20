package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.User;

import java.util.List;

public interface UserRepository {

    User registerUser(User entity);

    List<User> findAllTenants();

    List<User> findAllLandlords();

    User updateUserRating(int userId, User model);

    User updateUserOnlineStatus(int userId, User model);

    User getUserByUsername(String pattern);

    List<User> findUserByRating(double pattern);
}
