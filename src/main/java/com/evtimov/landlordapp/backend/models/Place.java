package com.evtimov.landlordapp.backend.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placeId")
    private int placeID;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usersplaces",
            joinColumns = @JoinColumn(name = "placeId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users;

    @OneToMany
    @JoinColumn(name = "placeId")
    private Set<Report> reports;

    @OneToMany
    @JoinColumn(name = "placeId")
    private Set<Rent> rents;

    public Place(){
        //default
    }

    public Place(int placeID, String address, String description){
        setPlaceID(placeID);
        setAddress(address);
        setDescription(description);
    }


    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }

    public Set<Rent> getRents() {
        return rents;
    }

    public void setRents(Set<Rent> rents) {
        this.rents = rents;
    }
}
