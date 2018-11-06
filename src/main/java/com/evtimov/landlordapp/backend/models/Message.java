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

<<<<<<< HEAD
    @Column(name = "sender_token")
    private String senderRegistrationToken;

    @Column(name = "receiver_token")
    private String receiverToken;

    /*@Column(name = "landlordId")
    private int landlordID;
*/
    /*@Column(name = "chatsessionId")
=======
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
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4
    private int chatSessionID;
*/
    @Column(name = "text")
    @NotNull(message = "Text message cannot be null! Please enter something!")
    @Size(min = 1, max = 16777215, message = "Enter a message with length between 1 and 16777215!")
    private String text;

    @Column(name = "picture")
    private String picture;

<<<<<<< HEAD
/*    @Column(name = "isdelivered")
    private boolean isDelivered;

    @Column(name = "archive")
    private boolean isArchived;*/
=======
    @Column(name = "isdelivered")
    @NotNull(message = "Is delivered cannot be null!")
    private boolean isDelivered;

    @Column(name = "archive")
    @NotNull(message = "Is archived cannot be null!")
    private boolean isArchived;
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4


    public Message() {
        //default
    }

    public Message(Date timestamp, String text,
<<<<<<< HEAD
                   String picture, int tenantID, int landlordID, boolean isDelivered, int chatSessionId, boolean isArchived, String senderRegistrationToken, String receiverToken) {
        this.receiverToken = receiverToken;
        setSenderRegistrationToken(senderRegistrationToken);
        /*setArchived(isArchived);
=======
                   String picture, int senderID, int receiverID, boolean isDelivered, int chatSessionId, boolean isArchived) {
        setArchived(isArchived);
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4
        setChatSessionId(chatSessionId);
        setSenderID(senderID);
        setReceiverID(receiverID);
        setIsDelivered(isDelivered);
        */
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

<<<<<<< HEAD
    public String getSenderRegistrationToken() {
        return senderRegistrationToken;
    }

    public void setSenderRegistrationToken(String senderRegistrationToken) {
        this.senderRegistrationToken = senderRegistrationToken;
    }

    public String getReceiverToken() {
        return receiverToken;
    }

    public void setReceiverToken(String receiverToken) {
        this.receiverToken = receiverToken;
    }

  /*  public int getTenantID() {
        return tenantID;
=======
    public int getSenderID() {
        return senderID;
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4
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
    }*/
}
