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

    @Column(name = "placeId")
    private int placeID;

    @Column(name = "rentId")
    private int rentID;

    @ManyToOne
    @JoinColumn(name = "userId",insertable = false,updatable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "cardId",insertable = false,updatable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "placeId",insertable = false,updatable = false)
    private Place place;

    @ManyToOne
    @JoinColumn(name = "rentId",insertable = false,updatable = false)
    private Rent rent;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date")
    private Date date;

    public Payment(){
        //default
    }

    public Payment(int paymentID, double amount, Date date, int userID, int cardID, int placeID, int rentID){
        setRentID(rentID);
        setPlaceID(placeID);
        setUserID(userID);
        setCardID(cardID);
        setPaymentID(paymentID);
        setAmount(amount);
        setDate(date);
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public int getRentID() {
        return rentID;
    }

    public void setRentID(int rentID) {
        this.rentID = rentID;
    }
}
