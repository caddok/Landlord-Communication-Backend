package com.evtimov.landlordapp.backend.models;


import com.evtimov.landlordapp.backend.utils.Constants;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;
import org.apache.tomcat.util.bcel.Const;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = Constants.RENTS)
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.RENT_ID)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.RENT_ID_TOO_BIG)
    private int rentID;

    @Column(name = Constants.RENT_TOTAL)
    @DecimalMax(value = Constants.RENT_TOTAL_MAX_VALUE, message = Constants.RENT_TOTAL_AMOUNT_TOO_BIG)
    @DecimalMin(value = Constants.RENT_TOTAL_MIN_VALUE, message = Constants.RENT_TOTAL_AMOUNT_TOO_SMALL)
    @NotNull(message = Constants.RENT_AMOUNT_NULL_MESSAGE)
    private double totalAmount;

    @Column(name = Constants.PLACE_ID)
    @NotNull(message = Constants.PLACE_ID_NULL_MESSAGE)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.PLACE_ID_MAX_MESSAGE)
    private int placeID;

    @Column(name = Constants.RENT_REMAINING)
    @DecimalMax(value = Constants.RENT_REMAINING_MAX_VALUE, message = Constants.RENT_REMAINING_MAX_VALUE_MESSAGE)
    @NotNull(message = Constants.RENT_REMAINING_NULL_MESSAGE)
    private double remaining;

    @Column(name = Constants.IS_PAID)
    @NotNull(message = Constants.IS_PAID_NULL_MESSAGE)
    private boolean isPaid;

    @Column(name = Constants.DUE_DATE)
    @NotNull(message = Constants.DUE_DATE_NULL_MESSAGE)
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
