package com.evtimov.landlordapp.backend.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placeId")
    @Max(value = 2147483647, message = "Place ID is too big!")
    private int placeID;

    @Column(name = "tenantId")
    @Min(value = 1, message = "Tenant ID must be at least 1!")
    @Max(value = 2147483647, message = "Tenant ID is too big!")
    private int tenantID;

    @Column(name = "landlordId")
    @NotNull(message = "Landlord ID cannot be null!")
    @Min(value = 1, message = "Landlord ID must be at least 1!")
    @Max(value = 2147483647, message = "Landlord ID is too big!")
    private int landlordID;

    @Column(name = "address")
    @NotNull(message = "Address cannot be null! Please enter something!")
    @Size(min = 1, max = 55, message = "Enter address with length between 1 and 55!")
    private String address;

    @Column(name = "description")
    @NotNull(message = "Description cannot be null! Please enter something!")
    @Size(min = 1, max = 16777215, message = "Enter description with length between 1 and 16777215!")
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "placeId", insertable = false, updatable = false)
    private Set<Rent> rents;

    public Place() {
        //default
    }

    public Place(String address, String description, int tenantID, int landlordID) {
        setTenantID(tenantID);
        setLandlordID(landlordID);
        setAddress(address);
        setDescription(description);
    }


    public int getPlaceID() {
        return placeID;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public Set<Rent> getRents() {
        return rents;
    }

    public int getTenantID() {
        return tenantID;
    }

    private void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public int getLandlordID() {
        return landlordID;
    }

    private void setLandlordID(int landlordID) {
        this.landlordID = landlordID;
    }
}
