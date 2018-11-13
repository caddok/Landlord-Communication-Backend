package com.evtimov.landlordapp.backend.models;


import com.evtimov.landlordapp.backend.utils.Constants;
import org.apache.tomcat.util.bcel.Const;

import javax.persistence.*;
import javax.validation.Configuration;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = Constants.MESSAGES)
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.MESSAGE_ID)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.MESSAGE_ID_MAX_MESSAGE)
    private int messageID;

    @Column(name = Constants.TIMESTAMP)
    private String timestamp;

    @Column(name = Constants.SENDER_ID)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.SENDER_ID_MAX_MSSG)
    @NotNull(message = Constants.SENDER_ID_NULL_MESSAGE)
    private int senderID;

    @Column(name = Constants.RECEIVER_ID)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.RECEIVER_ID_MAX_MSSG)
    @NotNull(message = Constants.RECEIVER_ID_NULL_MESSAGE)
    private int receiverID;

    @Column(name = Constants.CHATSESSIONS_ID)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.CHATSESSIONS_ID_MAX)
    @NotNull(message = Constants.CHATSESSION_ID_NULL_MESSAGE)
    private int chatsessionId;

    @Column(name = Constants.TEXT)
    @NotNull(message = Constants.TEXT_NULL_MESSAGE)
    @Size(min = 1, max = Constants.TEXT_MAX_LENGTH, message = Constants.TEXT_LENGTH_CONSTR)
    private String text;



    public Message() {
        //default
    }

    public Message(String timestamp, String text, int senderID, int receiverID, int chatSessionId) {
        setChatsessionId(chatSessionId);
        setSenderID(senderID);
        setReceiverID(receiverID);
        setTimestamp(timestamp);
        setText(text);
    }


    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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

    public int getChatsessionId() {
        return chatsessionId;
    }

    public void setChatsessionId(int chatsessionId) {
        this.chatsessionId = chatsessionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}