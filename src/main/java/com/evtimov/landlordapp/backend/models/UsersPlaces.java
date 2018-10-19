package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;

@Entity
@Table(name = "usersplaces")
public class UsersPlaces {

    @Id
    @Column(name = "userId")
    private int userID;

    @Id
    @Column(name = "placeId")
    private int placeID;

    public UsersPlaces(){
        //default
    }

    public UsersPlaces(int userID, int placeID){
        setUserID(userID);
        setPlaceID(placeID);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }
}
