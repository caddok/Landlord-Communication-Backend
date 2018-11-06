package com.evtimov.landlordapp.backend.controllers;

import com.evtimov.landlordapp.backend.models.User;
import com.evtimov.landlordapp.backend.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/users")
<<<<<<< HEAD
public class UserController {                    //CHECKED
=======
public class UserController {

>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @RequestMapping(method = RequestMethod.POST)
<<<<<<< HEAD
    public User registerUser(@RequestBody User user){
        service.registerUser(user);
        return user;
=======
    public User registerUser(@RequestBody @Valid User user){
        return service.registerUser(user);
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4
    }

    @RequestMapping(value = "/{username}",method = RequestMethod.POST)
    public ResponseEntity<String> getRegistrationToken(@PathVariable String username, String token) {
        User user = service.findUserByUsername(username);
        service.updateUserRegistrationToken(user.getUserID(),token);
        return ResponseEntity.ok(token);
    }

    @RequestMapping(value = "/tenants", method = RequestMethod.GET)
    public List<User> getAllTenants(){
        return service.findAllTenants();
    }

    @RequestMapping(/*value = "/landlords", */method = RequestMethod.GET)
    public List<User> getAllLandlords(){
        return service.findAllLandlords();
    }

    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable(value = "username") String username){
        return service.findUserByUsername(username);
    }

    @RequestMapping(value = "/checkusername/{username}", method = RequestMethod.GET)
    public User checkUsername(@PathVariable(value = "username") String username){
        return service.checkUsername(username);
    }

    @RequestMapping(value = "/checkemail/{email}", method = RequestMethod.GET)
    public User checkEmail(@PathVariable(value = "email") String email){
        return service.checkEmail(email);
    }

    @RequestMapping(value = "/gethashandsalt/{username}", method = RequestMethod.GET)
    public User getUserHashAndSaltByUsername(@PathVariable(value = "username") String username){
        return service.getUserHashAndSaltByUsername(username);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(value = "userId") int userId){
        return service.getUserById(userId);
    }
}
