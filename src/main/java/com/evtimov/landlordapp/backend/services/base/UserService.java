package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.User;

import java.util.List;

public interface UserService {

    User registerUser(User entity); //

    List<User> findAllTenants();//

    List<User> findAllLandlords();//

    User updateUserOnlineStatus(int userId, User model);//

    User findUserByUsername(String pattern);//

    User getUserHashAndSaltByUsername(String username);//

    User checkUsername(String pattern);//

    User checkEmail(String pattern);//

    User getUserById(int userId);//
}
