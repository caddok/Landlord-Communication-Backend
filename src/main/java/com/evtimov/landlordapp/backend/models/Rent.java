package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "rents")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentId")
    @Max(value = 2147483647, message = "Rent ID is too big!")
    private int rentID;

    @Column(name = "totalamount")
    @DecimalMax(value = "99999.99", message = "Amount is too big!")
    @DecimalMin(value = "0.0", message = "Amount cannot be negative!")
    @NotNull(message = "Amount cannot be null!")
    private double totalAmount;

    @Column(name = "placeId")
    @NotNull(message = "Place ID cannot be null!")
    @Min(value = 1, message = "Place ID must be at least 1!")
    @Max(value = 2147483647, message = "Place ID is too big!")
    private int placeID;

    @Column(name = "remaining")
    @DecimalMax(value = "99999.99", message = "Remaining is too big!")
    @DecimalMin(value = "0.0", message = "Remaining cannot be negative!")
    @NotNull(message = "Remaining cannot be null!")
    private double remaining;

    @Column(name = "ispaid")
    @NotNull(message = "Is paid cannot be null!")
    private boolean isPaid;

    @Column(name = "duedate")
    @NotNull(message = "Date cannot be null!")
    private String dueDate;


    public Rent() {
        //default
    }

    public Rent(double totalAmount, double remaining, boolean isPaid, String dueDate, int placeID) {
        setPlaceID(placeID);
        setTotalAmount(totalAmount);
        setRemaining(remaining);
        setIsPaid(isPaid);
        setDueDate(dueDate);
    }

    public int getRentID() {
        return rentID;
    }

    private void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getRemaining() {
        return remaining;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }

    public boolean getIsPaid() {
        return this.isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getPlaceID() {
        return placeID;
    }

    private void setPlaceID(int placeID) {
        this.placeID = placeID;
    }
}
