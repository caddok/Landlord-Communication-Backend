package com.evtimov.landlordapp.backend.models;

import com.evtimov.landlordapp.backend.utils.Constants;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = Constants.CHATSESSIONS)
public class ChatSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.CHATSESSIONS_ID)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.CHATSESSIONS_ID_MAX)
    private int chatsessionId;

    @Column(name = Constants.TENANT_ID)
    @NotNull(message = Constants.TENANT_ID_NULL_MESSAGE)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.TENANT_ID_MAX_MESSAGE)
    private int tenantID;

    @Column(name = Constants.LANDLORD_ID)
    @NotNull(message = Constants.LANDLORD_ID_NULL_MESSAGE)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.LANDLORD_ID_MAX_MESSAGE)
    private int landlordID;

    @Column(name = Constants.CREATE_DATE)
    @NotNull(message = Constants.DATE_NOT_NULL)
    private String createDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = Constants.CHATSESSIONS_ID, insertable = false, updatable = false)
    private List<Message> messages;


    public ChatSession() {
        //default
    }

    public ChatSession(String createDate, int tenantID, int landlordID) {
        setTenantID(tenantID);
        setLandlordID(landlordID);
        setCreateDate(createDate);
    }


    public int getChatsessionId() {
        return chatsessionId;
    }

    public void setChatsessionId(int chatsessionId) {
        this.chatsessionId = chatsessionId;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public int getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(int landlordID) {
        this.landlordID = landlordID;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
