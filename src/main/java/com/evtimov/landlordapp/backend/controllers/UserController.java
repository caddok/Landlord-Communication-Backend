package com.evtimov.landlordapp.backend.controllers;

import com.evtimov.landlordapp.backend.models.User;
import com.evtimov.landlordapp.backend.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public User registerUser(@RequestBody @Valid User user){
        service.registerUser(user);

        return user;
    }

    @RequestMapping(value = "/tenants", method = RequestMethod.GET)
    public List<User> getAllTenants(){
        return service.findAllTenants();
    }

    @RequestMapping(value = "/landlords", method = RequestMethod.GET)
    public List<User> getAllLandlords(){
        return service.findAllLandlords();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable(value = "username") String username){
        return service.findUserByUsername(username);
    }


    @RequestMapping(value = "/updatestatus/{userId}", method = RequestMethod.PUT)
    public User updateUserOnlineStatus(@PathVariable(value = "userId") int userId, @RequestBody User user){

        service.updateUserOnlineStatus(userId, user);

        return user;
    }

    @RequestMapping(value = "/checkusername/{username}", method = RequestMethod.GET)
    public String checkUsername(@PathVariable(value = "username") String username){
        return service.checkUsername(username);
    }

    @RequestMapping(value = "/checkemail/{email}", method = RequestMethod.GET)
    public String checkEmail(@PathVariable(value = "email") String email){
        return service.checkEmail(email);
    }
}
