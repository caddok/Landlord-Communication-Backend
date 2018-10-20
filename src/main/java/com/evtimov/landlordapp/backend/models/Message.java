package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageId")
    private int messageID;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "tenantId")
    private int tenantID;

    @Column(name = "landlordId")
    private int landlordID;

    @Column(name = "text")
    private String text;

    @Column(name = "picture")
    private String picture;

    @Column(name = "isdelivered")
    private boolean isDelivered;


    public Message() {
        //default
    }

    public Message(Date timestamp, String text,
                   String picture, int tenantID, int landlordID, boolean isDelivered) {
        setTenantID(tenantID);
        setLandlordID(landlordID);
        setIsDelivered(isDelivered);
        setTimestamp(timestamp);
        setText(text);
        setPicture(picture);
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getTenantID() {
        return tenantID;
    }

    private void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public int getLandlordID() {
        return landlordID;
    }

    private void setLandlordID(int landlordID) {
        this.landlordID = landlordID;
    }

    public boolean getIsDelivered() {
        return isDelivered;
    }

    private void setIsDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }
}
