package com.evtimov.landlordapp.backend.controllers;

import com.evtimov.landlordapp.backend.models.User;
import com.evtimov.landlordapp.backend.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;


    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @RequestMapping(method = RequestMethod.POST)
    public User registerUser(@RequestBody User user){
        service.registerUser(user);

        return user;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllTenants(){
        return service.findAllTenants();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllLandlords(){
        return service.findAllLandlords();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable(value = "username") String username){
        return service.findUserByUsername(username);
    }

    @RequestMapping(value = "/{rating}", method = RequestMethod.GET)
    public List<User> getUsersByRating(@PathVariable(value = "rating") String rating){
        return service.findUserByRating(rating);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public User updateUserData(@PathVariable(value = "userId") int userId, @RequestBody User user){

        service.updateUserData(userId, user);

        return user;
    }
}
