package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userID;

    @Column(name = "islandlord")
    private boolean isLandlord;

    @Column(name = "username")
    private String username;

    @Column(name = "picture")
    private String picture;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "isonline")
    private boolean isOnline;

    @Column(name = "rating")
    private double rating;

    @Column(name = "passwordhash")
    private String passwordHash;

    @Column(name = "passwordsalt")
    private String passwordSalt;

    @Column(name = "votes")
    private int votes;

    @Column(name = "votesum")
    private double voteSum;


    public User() {
        //default
    }

    public User(int userID, boolean isLandlord, String username, String picture, String firstName, String lastName, String email,
                boolean isOnline, String passwordHash, String passwordSalt, int votes, double voteSum) {
        setUserID(userID);
        setIsLandlord(isLandlord);
        setUsername(username);
        setPicture(picture);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setIsOnline(isOnline);
        setPasswordHash(passwordHash);
        setPasswordSalt(passwordSalt);
        setVotes(votes);
        setVoteSum(voteSum);
    }

    public int getUserID() {
        return userID;
    }

    private void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean getIsLandlord() {
        return this.isLandlord;
    }

    private void setIsLandlord(boolean isLandlord) {
        this.isLandlord = isLandlord;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    private void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    private void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

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
}
