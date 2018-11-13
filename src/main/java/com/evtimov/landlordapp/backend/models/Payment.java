package com.evtimov.landlordapp.backend.models;


import com.evtimov.landlordapp.backend.utils.Constants;

import javax.persistence.*;
import javax.validation.Configuration;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = Constants.PAYMENTS)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.PAYMENT_ID)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.PAYMENT_ID_TOO_BIG)
    private int paymentID;

    @Column(name = Constants.USER_ID)
    @NotNull(message = Constants.USER_ID_NULL_MESSAGE)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.USER_ID_MAX_VALUE_MESSAGE)
    private int userID;

    @Column(name = Constants.CARD_ID)
    @NotNull(message = Constants.CARD_ID_NULL_MESSAGE)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.CARD_ID_MESSAGE)
    private int cardID;

    @Column(name = Constants.RENT_ID)
    @NotNull(message = Constants.RENT_ID_NULL_MESSAGE)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.RENT_ID_TOO_BIG)
    private int rentID;

    @Column(name = Constants.PLACE_ID)
    @NotNull(message = Constants.PLACE_ID_NULL_MESSAGE)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.PLACE_ID_MAX_MESSAGE)
    private int placeID;

    @Column(name = Constants.AMOUNT)
    @DecimalMax(value = Constants.PAYMENT_AMOUNT_MAX_VALUE, message = Constants.PAYMENT_AMOUNT_MAX_VALUE_MESSAGE)
    @DecimalMin(value = Constants.PAYMENT_AMOUNT_MIN_VALUE, message = Constants.PAYMENT_AMOUNT_MIN_VALUE_MESSAGE)
    @NotNull(message = Constants.PAYMENT_AMOUNT_NULL_MESSAGE)
    private double amount;

    @Column(name = Constants.DATE)
    @NotNull(message = Constants.DATE_NOT_NULL)
    @Size(min = 1, max = 11, message = Constants.DATE_LENGTH_CONSTR)
    private String date;

    @ManyToOne
    @JoinColumn(name = Constants.CARD_ID, insertable = false, updatable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = Constants.RENT_ID, insertable = false, updatable = false)
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = Constants.PLACE_ID, insertable = false, updatable = false)
    private Place place;

    @ManyToOne
    @JoinColumn(name = Constants.USER_ID, insertable = false, updatable = false)
    private User user;


    public Payment() {
        //default
    }

    public Payment(double amount, String date, int userID, int cardID, int rentID, int placeID) {
        setRentID(rentID);
        setUserID(userID);
        setCardID(cardID);
        setAmount(amount);
        setDate(date);
        setPlaceID(placeID);
    }

    public int getPaymentID() {
        return paymentID;
    }

    private void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public double getAmount() {
        return amount;
    }

    private void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    private void setDate(String date) {
        this.date = date;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getUserID() {
        return userID;
    }

    private void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCardID() {
        return cardID;
    }

    private void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public int getRentID() {
        return rentID;
    }

    private void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
