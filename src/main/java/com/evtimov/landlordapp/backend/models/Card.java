package com.evtimov.landlordapp.backend.models;


import com.evtimov.landlordapp.backend.utils.Constants;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = Constants.CARD_SQL_TABLE_NAME)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.CARD_ID)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.CARD_ID_MESSAGE)
    private int cardID;

    @Column(name = Constants.BRAND_CARD)
    @NotNull(message = Constants.BRAND_NULL_MESSAGE)
    @Size(min = 1, max = 45, message = Constants.BRAND_SIZE_MESSAGE)
    private String brand;

    @Column(name = Constants.CARD_TYPE)
    @NotNull(message = Constants.CARD_TYPE_NULL_MESSAGE)
    @Size(min = 1, max = 45, message = Constants.CARD_TYPE_SIZE_MESSAGE)
    private String type;

    @Column(name = Constants.CARD_NUMBER)
    @NotNull(message = Constants.CARD_NUMBER_NULL_MESSAGE)
    @Size(min = 16, max = 16, message = Constants.CARD_NUMBER_SIZE_MESSAGE)
    private String cardNumber;

    @Column(name = Constants.CVV_NUMBER)
    @NotNull(message = Constants.CVV_NULL_MESSAGE)
    @Size(min = 3, max = 3, message = Constants.CVV_SIZE_MESSAGE)
    private String cvvNumber;

    @Column(name = Constants.BALANCE)
    @DecimalMax(value = Constants.BALANCE_MAX_VALUE, message = Constants.BALANCE_MAX_VALUE_MESSAGE)
    @DecimalMin(value = Constants.BALANCE_MIN_VALUE, message = Constants.BALANCE_MIN_SIZE_MESSAGE)
    @NotNull(message = Constants.BALANCE_NULL_MESSAGE)
    private double balance;

    @Column(name = Constants.USER_ID)
    @Min(value = 1, message = Constants.USER_ID_MIN_VALUE_MESSAGE)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.USER_ID_MAX_VALUE_MESSAGE)
    @NotNull(message = Constants.USER_ID_NULL_MESSAGE)
    private int userID;

    public Card() {
        //default
    }

    public Card(String brand, String type, String cardNumber, String cvvNumber, double balance, int userID) {
        setUserID(userID);
        setBrand(brand);
        setType(type);
        setCardNumber(cardNumber);
        setCvvNumber(cvvNumber);
        setBalance(balance);
    }

    public int getCardID() {
        return cardID;
    }

    private void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    private void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    private void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getUserID() {
        return userID;
    }

    private void setUserID(int userID) {
        this.userID = userID;
    }
}
