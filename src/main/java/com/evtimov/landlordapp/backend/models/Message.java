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

    @Column(name = "sender_token")
    private String senderRegistrationToken;

    @Column(name = "receiver_token")
    private String receiverToken;

    /*@Column(name = "landlordId")
    private int landlordID;
*/
    /*@Column(name = "chatsessionId")
    private int chatSessionID;
*/
    @Column(name = "text")
    private String text;

    @Column(name = "picture")
    private String picture;

/*    @Column(name = "isdelivered")
    private boolean isDelivered;

    @Column(name = "archive")
    private boolean isArchived;*/


    public Message() {
        //default
    }

    public Message(Date timestamp, String text,
                   String picture, int tenantID, int landlordID, boolean isDelivered, int chatSessionId, boolean isArchived, String senderRegistrationToken, String receiverToken) {
        this.receiverToken = receiverToken;
        setSenderRegistrationToken(senderRegistrationToken);
        /*setArchived(isArchived);
        setChatSessionId(chatSessionId);
        setTenantID(tenantID);
        setLandlordID(landlordID);
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
