package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private int paymentID;

    @Column(name = "userId")
    private int userID;

    @Column(name = "cardId")
    private int cardID;

    @Column(name = "rentId")
    private int rentID;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "cardId", insertable = false, updatable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "placeId", insertable = false, updatable = false)
    private Place place;

    @ManyToOne
    @JoinColumn(name = "rentId", insertable = false, updatable = false)
    private Rent rent;


    public Payment() {
        //default
    }

    public Payment(double amount, Date date, int userID, int cardID, int rentID) {
        setRentID(rentID);
        setUserID(userID);
        setCardID(cardID);
        setAmount(amount);
        setDate(date);
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

    public Date getDate() {
        return date;
    }

    private void setDate(Date date) {
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
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
}
