package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardId")
    @Min(value = 1, message = "Card ID must be at least 1!")
    @Max(value = 2147483647, message = "Card ID is too big!")
    @NotNull(message = "Card ID cannot be null!")
    private int cardID;

    @Column(name = "brand")
    @NotNull(message = "Brand name cannot be null! Please enter brand!")
    @Size(min = 1, max = 45, message = "Enter a brand name with length between 1 and 45!")
    private String brand;

    @Column(name = "type")
    @NotNull(message = "Card type cannot be null! Please enter card type!")
    @Size(min = 1, max = 45, message = "Enter a card type with length between 1 and 45!")
    private String type;

    @Column(name = "cardnumber")
    @NotNull(message = "Card number cannot be null! Please enter number!")
    @Size(min = 1, max = 16, message = "Enter a card number with length between 1 and 16!")
    private String cardNumber;

    @Column(name = "cvvnumber")
    @NotNull(message = "CVV card number cannot be null!")
    @Min(value = 100)
    @Max(value = 999)
    private int cvvNumber;

    @Column(name = "balance")
    @DecimalMax(value = "9999999.99", message = "Balance is too big!")
    @DecimalMin(value = "0.0", message = "Balance cannot be negative!")
    @NotNull(message = "Balance cannot be null!")
    private double balance;

    @Column(name = "userId")
    @Min(value = 1, message = "User ID must be at least 1!")
    @Max(value = 2147483647, message = "User ID is too big!")
    @NotNull(message = "User ID cannot be null!")
    private int userID;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    public Card() {
        //default
    }

    public Card(String brand, String type, String cardNumber, int cvvNumber, double balance, int userID) {
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
