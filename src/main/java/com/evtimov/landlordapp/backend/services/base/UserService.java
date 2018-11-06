package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.User;

import java.util.List;

public interface UserService {

    User registerUser(User entity);

    List<User> findAllTenants();

    List<User> findAllLandlords();

    User updateUserRating(int userId, User model);

    User updateUserOnlineStatus(int userId, User model);

    String updateUserRegistrationToken(int userId, String token);

    User findUserByUsername(String pattern);

    List<User> findUserByRating(double pattern);

    String checkUsername(String pattern);

    String checkEmail(String pattern);

}
