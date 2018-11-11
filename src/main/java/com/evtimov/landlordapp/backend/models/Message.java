package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageId")
    @Max(value = 2147483647, message = "Message ID is too big!")
    private int messageID;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "senderId")
    @Max(value = 2147483647, message = "Sender ID is too big!")
    @NotNull(message = "Sender ID cannot be null!")
    private int senderID;

    @Column(name = "receiverId")
    @Max(value = 2147483647, message = "Receiver ID is too big!")
    @NotNull(message = "Receiver ID cannot be null!")
    private int receiverID;

    @Column(name = "chatsessionId")
    @Max(value = 2147483647, message = "ChatSession ID is too big!")
    @NotNull(message = "ChatSession ID cannot be null!")
    private int chatsessionId;

    @Column(name = "text")
    @NotNull(message = "Text message cannot be null! Please enter something!")
    @Size(min = 1, max = 16777215, message = "Enter a message with length between 1 and 16777215!")
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
