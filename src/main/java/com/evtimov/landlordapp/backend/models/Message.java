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
    @NotNull(message = "Date cannot be null!")
    private Date timestamp;

    @Column(name = "senderId")
    @Min(value = 1, message = "Sender ID must be at least 1!")
    @Max(value = 2147483647, message = "Sender ID is too big!")
    @NotNull(message = "Sender ID cannot be null!")
    private int senderID;

    @Column(name = "receiverId")
    @Min(value = 1, message = "Receiver ID must be at least 1!")
    @Max(value = 2147483647, message = "Receiver ID is too big!")
    @NotNull(message = "Receiver ID cannot be null!")
    private int receiverID;

    @Column(name = "chatsessionId")
    @Min(value = 1, message = "ChatSession ID must be at least 1!")
    @Max(value = 2147483647, message = "ChatSession ID is too big!")
    @NotNull(message = "ChatSession ID cannot be null!")
    private int chatSessionID;

    @Column(name = "text")
    @NotNull(message = "Text message cannot be null! Please enter something!")
    @Size(min = 1, max = 16777215, message = "Enter a message with length between 1 and 16777215!")
    private String text;

    @Column(name = "picture")
    private String picture;

    @Column(name = "isdelivered")
    @NotNull(message = "Is delivered cannot be null!")
    private boolean isDelivered;

    @Column(name = "archive")
    @NotNull(message = "Is archived cannot be null!")
    private boolean isArchived;


    public Message() {
        //default
    }

    public Message(Date timestamp, String text,
                   String picture, int senderID, int receiverID, boolean isDelivered, int chatSessionId, boolean isArchived) {
        setArchived(isArchived);
        setChatSessionId(chatSessionId);
        setSenderID(senderID);
        setReceiverID(receiverID);
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

    private void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    private void setText(String text) {
        this.text = text;
    }

    public String getPicture() {
        return picture;
    }

    private void setPicture(String picture) {
        this.picture = picture;
    }

    public int getSenderID() {
        return senderID;
    }

    private void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    private void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public boolean getIsDelivered() {
        return isDelivered;
    }

    private void setIsDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public int getChatSessionId() {
        return chatSessionID;
    }

    private void setChatSessionId(int chatSessionId) {
        this.chatSessionID = chatSessionId;
    }

    public boolean isArchived() {
        return isArchived;
    }

    private void setArchived(boolean archived) {
        isArchived = archived;
    }
}
