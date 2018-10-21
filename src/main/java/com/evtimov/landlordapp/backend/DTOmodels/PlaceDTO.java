package com.evtimov.landlordapp.backend.DTOmodels;

import java.util.ArrayList;
import java.util.List;

public class PlaceDTO {

    private int placeID;

    private int tenantID;

    private int landlordID;

    private String address;

    private String description;

    private List<String> rents = new ArrayList<>();

    public PlaceDTO() {
        //default
    }

    public PlaceDTO(String address, String description, int tenantID, int landlordID) {
        setTenantID(tenantID);
        setLandlordID(landlordID);
        setAddress(address);
        setDescription(description);
    }

    public List<String> getRents() {
        return rents;
    }

    public void setRents(List<String> rents) {
        this.rents = rents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(int landlordID) {
        this.landlordID = landlordID;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }
}
