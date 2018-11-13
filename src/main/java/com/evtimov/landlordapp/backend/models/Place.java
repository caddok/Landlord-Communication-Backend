package com.evtimov.landlordapp.backend.models;

import com.evtimov.landlordapp.backend.utils.Constants;

import javax.persistence.*;
import javax.validation.Configuration;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = Constants.PLACES)
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.PLACE_ID)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.PLACE_ID_MAX_MESSAGE)
    private int placeID;

<<<<<<< HEAD
    @Column(name = Constants.TENANT_ID)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.TENANT_ID_MAX_MESSAGE)
=======
    @Column(name = "tenantId")
    @Max(value = 2147483647, message = "Tenant ID is too big!")
>>>>>>> a0e8c1fe79dc781f7ef9588f0f2a22137620308e
    private int tenantID;

    @Column(name = Constants.LANDLORD_ID)
    @NotNull(message = Constants.LANDLORD_ID_NULL_MESSAGE)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.LANDLORD_ID_MAX_MESSAGE)
    private int landlordID;

    @Column(name = Constants.ADDRESS)
    @NotNull(message = Constants.ADDRESS_NULL_MESSAGE)
    @Size(min = 1, max = 55, message = Constants.ADDRESS_LENGTH_MESSAGE)
    private String address;

    @Column(name = Constants.DESCRIPTION)
    @NotNull(message = Constants.DESCRIPTION_NULL_MESSAGE)
    @Size(min = 1, max = Constants.DESCRIPTION_MAX_VALUE, message = Constants.DESCRIPTION_LENGTH_MESSAGE)
    private String description;

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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public int getLandlordID() {
        return landlordID;
    }

    private void setLandlordID(int landlordID) {
        this.landlordID = landlordID;
    }
}
