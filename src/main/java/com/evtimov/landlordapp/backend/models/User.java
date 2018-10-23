package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    @NotNull(message = "User ID cannot be null!")
    @Min(value = 1, message = "User ID must be at least 1!")
    @Max(value = 2147483647, message = "User ID is too big!")
    private int userID;

    @Column(name = "islandlord")
    @NotNull(message = "Is landlord type cannot be null!")
    private boolean isLandlord;

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
    @NotNull(message = "Pass hash cannot be null! Please enter pass hash!")
    @Size(min = 1, max = 255, message = "Enter pass hash with length between 1 and 255!")
    private String passwordHash;

    @Column(name = "passwordsalt")
    @NotNull(message = "Pass salt cannot be null! Please enter pass salt!")
    @Size(min = 1, max = 255, message = "Enter pass salt with length between 1 and 255!")
    private String passwordSalt;



    public User() {
        //default
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
}
