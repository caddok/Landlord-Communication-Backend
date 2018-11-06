package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    @Max(value = 2147483647, message = "Payment ID is too big!")
    private int paymentID;

    @Column(name = "userId")
    @NotNull(message = "User ID cannot be null!")
    @Min(value = 1, message = "User ID must be at least 1!")
    @Max(value = 2147483647, message = "User ID is too big!")
    private int userID;

    @Column(name = "cardId")
    @NotNull(message = "Card ID cannot be null!")
    @Min(value = 1, message = "Card ID must be at least 1!")
    @Max(value = 2147483647, message = "Card ID is too big!")
    private int cardID;

    @Column(name = "rentId")
    @NotNull(message = "Rent ID cannot be null!")
    @Min(value = 1, message = "Rent ID must be at least 1!")
    @Max(value = 2147483647, message = "Rent ID is too big!")
    private int rentID;

    @Column(name = "placeId")
    @NotNull(message = "Place ID cannot be null!")
    @Min(value = 1, message = "Place ID must be at least 1!")
    @Max(value = 2147483647, message = "Place ID is too big!")
    private int placeID;

    @Column(name = "amount")
    @DecimalMax(value = "99999.99", message = "Amount is too big!")
    @DecimalMin(value = "0.0", message = "Amount cannot be negative!")
    @NotNull(message = "Amount cannot be null!")
    private double amount;

    @Column(name = "date")
    @NotNull(message = "Date cannot be null!")
    @Size(min = 1, max = 11, message = "Enter a date with length between 1 and 11!")
    private String date;

    @ManyToOne
    @JoinColumn(name = "cardId", insertable = false, updatable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "rentId", insertable = false, updatable = false)
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "placeId", insertable = false, updatable = false)
    private Place place;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
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
