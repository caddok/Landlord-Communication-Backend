package com.evtimov.landlordapp.backend.controllers;

import com.evtimov.landlordapp.backend.models.User;
import com.evtimov.landlordapp.backend.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {                    //CHECKED

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

    @RequestMapping(value = "/tenants", method = RequestMethod.GET)
    public List<User> getAllTenants(){
        return service.findAllTenants();
    }

    @RequestMapping(value = "landlords", method = RequestMethod.GET)
    public List<User> getAllLandlords(){
        return service.findAllLandlords();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable(value = "username") String username){
        return service.findUserByUsername(username);
    }

    @RequestMapping(value = "/rating/{rating}", method = RequestMethod.GET)
    public List<User> getUsersByRating(@PathVariable(value = "rating") double rating){
        return service.findUserByRating(rating);
    }


    @RequestMapping(value = "/updaterating/{userId}", method = RequestMethod.PUT)
    public User updateUserRating(@PathVariable(value = "userId") int userId, @RequestBody User user){

        service.updateUserRating(userId, user);

        return user;
    }

    @RequestMapping(value = "/updatestatus/{userId}", method = RequestMethod.PUT)
    public User updateUserOnlineStatus(@PathVariable(value = "userId") int userId, @RequestBody User user){

        service.updateUserOnlineStatus(userId, user);

        return user;
    }
}
