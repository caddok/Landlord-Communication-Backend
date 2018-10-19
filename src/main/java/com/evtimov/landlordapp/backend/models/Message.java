package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
import java.util.Date;
import com.evtimov.landlordapp.backend.models.User;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageId")
    private int messageID;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "senderId")
    private int senderID;

    @Column(name = "receiverId")
    private int receiverID;

    @ManyToOne
    @JoinColumn(name = "chatsessionId")
    private Chatsession chatsession;

    @Column(name = "text")
    private String text;

    @Column(name = "picture")
    private String picture;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "senderId",insertable = false,updatable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiverId", insertable = false, updatable = false)
    private User receiver;


    public Message() {
        //default
    }

    public Message(int messageID, Date timestamp, String text,
                   String picture, String status, int senderID, int receiverID) {
        setReceiverID(receiverID);
        setSenderID(senderID);
        setMessageID(messageID);
        setTimestamp(timestamp);
        setText(text);
        setPicture(picture);
        setStatus(status);
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Chatsession getChatsession() {
        return chatsession;
    }

    public void setChatsession(Chatsession chatsession) {
        this.chatsession = chatsession;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }
}
