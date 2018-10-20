package com.evtimov.landlordapp.backend.models;


import com.evtimov.landlordapp.backend.models.User;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardId")
    private int cardID;

    @Column(name = "brand")
    private String brand;

    @Column(name = "type")
    private String type;

    @Column(name = "cardnumber")
    private String cardNumber;

    @Column(name = "cvvnumber")
    private int cvvNumber;

    @Column(name = "balance")
    private double balance;

    @Column(name = "userId")
    private int userID;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    public Card() {
        //default
    }

    public Card(int cardID, String brand, String type, String cardNumber, int cvvNumber, double balance, int userID) {
        setUserID(userID);
        setBrand(brand);
        setType(type);
        setCardNumber(cardNumber);
        setCvvNumber(cvvNumber);
        setCardID(cardID);
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

    public int getCvvNumber() {
        return cvvNumber;
    }

    private void setCvvNumber(int cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public int getUserID() {
        return userID;
    }

    private void setUserID(int userID) {
        this.userID = userID;
    }
}
