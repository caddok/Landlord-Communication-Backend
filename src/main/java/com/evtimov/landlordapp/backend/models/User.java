package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
<<<<<<< HEAD
=======
import javax.validation.constraints.*;
import java.util.Set;
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "user_id")
=======
    @Column(name = "userId")
    @Max(value = 2147483647, message = "User ID is too big!")
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4
    private int userID;

    @Column(name = "islandlord")
    @NotNull(message = "Is landlord type cannot be null!")
    private boolean isLandlord;

    @Column(name = "registrationtoken")
    private String registrationToken;

    @Column(name = "username")
    @NotNull(message = "Username cannot be null! Please enter username!")
    @Size(min = 1, max = 45, message = "Enter username with length between 1 and 45!")
    private String username;

    @Column(name = "picture")
    private String picture;

    @Column(name = "firstname")
    @NotNull(message = "First name cannot be null! Please enter first name!")
    @Size(min = 1, max = 45, message = "Enter first name with length between 1 and 45!")
    private String firstName;

    @Column(name = "lastname")
    @NotNull(message = "Last name cannot be null! Please enter last name!")
    @Size(min = 1, max = 45, message = "Last first name with length between 1 and 45!")
    private String lastName;

    @Column(name = "email")
    @NotNull(message = "Email cannot be null! Please enter email!")
    @Size(min = 1, max = 45, message = "Enter email with length between 1 and 45!")
    private String email;

    @Column(name = "isonline")
    @NotNull(message = "Online status cannot be null!")
    private boolean isOnline;

    @Column(name = "passwordhash")
    @Size(min = 1, max = 255, message = "Enter pass hash with length between 1 and 255!")
    private String passwordHash;

    @Column(name = "passwordsalt")
    @Size(min = 1, max = 255, message = "Enter pass salt with length between 1 and 255!")
    private String passwordSalt;


    public User() {
        //default
    }

    public User(String passwordHash, String passwordSalt){
        setPasswordHash(passwordHash);
        setPasswordSalt(passwordSalt);
    }

    public User(boolean isLandlord, String username, String picture, String firstName, String lastName, String email,
<<<<<<< HEAD
                boolean isOnline, String passwordHash, String passwordSalt, int votes, double voteSum, String registrationToken) {
        this.registrationToken = registrationToken;
=======
                boolean isOnline, String passwordHash, String passwordSalt) {
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4
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
<<<<<<< HEAD

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public double getVoteSum() {
        return voteSum;
    }

    public void setVoteSum(double voteSum) {
        this.voteSum = voteSum;
    }

    public String getRegistrationToken() {
        return registrationToken;
    }

    public void setRegistrationToken(String registrationToken) {
        this.registrationToken = registrationToken;
    }
=======
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4
}
