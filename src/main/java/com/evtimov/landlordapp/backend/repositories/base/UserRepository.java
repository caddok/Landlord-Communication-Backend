package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.User;

import java.util.List;

public interface UserRepository {

    User registerUser(User entity);

    List<User> findAllTenants();

    List<User> findAllLandlords();

    User updateUserOnlineStatus(int userId, User model);

    List<User> getUserByUsername(String pattern);

    List<User> getUserHashAndSaltByUsername(String username);

    List<User> checkUsername(String pattern);

    List<User> checkEmail(String pattern);

    User getUserById(int userId);
}
