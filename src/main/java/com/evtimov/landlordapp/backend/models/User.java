package com.evtimov.landlordapp.backend.models;


import com.evtimov.landlordapp.backend.utils.Constants;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;
import org.apache.tomcat.util.bcel.Const;
import org.yaml.snakeyaml.scanner.Constant;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = Constants.USERS)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.USER_ID)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.USER_ID_MAX_VALUE_MESSAGE)
    private int userID;

    @Column(name = Constants.IS_LANDLORD)
    @NotNull(message = Constants.IS_LANDLORD_NULL_MESSAGE)
    private boolean isLandlord;

    @Column(name = Constants.USERNAME)
    @NotNull(message = Constants.USERNAME_NULL_MESSAGE)
    @Size(min = 1, max = 45, message = Constants.USERNAME_LENGTH_CONSTRAINT_MESSAGE)
    private String username;

    @Column(name = Constants.PICTURE)
    private String picture;

    @Column(name = Constants.FIRST_NAME)
    @NotNull(message = Constants.FIRST_NAME_NULL_MESSAGE)
    @Size(min = 1, max = 45, message = Constants.FIRST_NAME_LENGTH_CONSTRAINT_MESSAGE)
    private String firstName;

    @Column(name = Constants.LAST_NAME)
    @NotNull(message = Constants.LAST_NAME_NULL_MESSAGE)
    @Size(min = 1, max = 45, message = Constants.LAST_NAME_LENGTH_CONSTRAINT_MESSAGE)
    private String lastName;

    @Column(name = Constants.EMAIL)
    @NotNull(message = Constants.EMAIL_NULL_MESSAGE)
    @Size(min = 1, max = 45, message = Constants.EMAIL_LENGTH_CONSTRAINT_MESSAGE)
    private String email;

    @Column(name = Constants.IS_ONLINE)
    @NotNull(message = Constants.IS_ONLINE_NULL_MESSAGE)
    private boolean isOnline;

    @Column(name = Constants.PASS_HASH)
    @Size(min = 1, max = 255, message = Constants.PASS_HASH_LENGTH_CONSTRAINTS)
    private String passwordHash;

    @Column(name = Constants.PASS_SALT)
    @Size(min = 1, max = 255, message = Constants.PASS_SALT_LENGTH_CONSTRAINTS_MESSAGE)
    private String passwordSalt;



    public User() {
        //default
    }

    public User(String passwordHash, String passwordSalt){
        setPasswordHash(passwordHash);
        setPasswordSalt(passwordSalt);
    }


    public User(boolean isLandlord, String username, String picture, String firstName, String lastName, String email,
                boolean isOnline, String passwordHash, String passwordSalt) {
        setIsLandlord(isLandlord);
        setUsername(username);
        setPicture(picture);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setIsOnline(isOnline);
        setPasswordHash(passwordHash);
        setPasswordSalt(passwordSalt);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserId(int userId){ this.userID = userId;}

    public boolean getIsLandlord() {
        return this.isLandlord;
    }

    public void setIsLandlord(boolean isLandlord) {
        this.isLandlord = isLandlord;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsOnline() {
        return this.isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
}