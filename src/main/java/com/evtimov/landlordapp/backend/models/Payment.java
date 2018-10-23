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
    @NotNull(message = "Payment ID cannot be null!")
    @Min(value = 1, message = "Payment ID must be at least 1!")
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

    @Column(name = "amount")
    @DecimalMax(value = "99999.99", message = "Amount is too big!")
    @DecimalMin(value = "0.0", message = "Amount cannot be negative!")
    @NotNull(message = "Amount cannot be null!")
    private double amount;

    @Column(name = "date")
    @NotNull(message = "Date cannot be null!")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "cardId", insertable = false, updatable = false)
    private Card card;

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
