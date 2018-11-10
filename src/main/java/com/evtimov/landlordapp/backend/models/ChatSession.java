package com.evtimov.landlordapp.backend.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "chatsessions")
public class ChatSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatsessionId")
    @Max(value = 2147483647, message = "ChatSession ID is too big!")
    private int chatsessionId;

    @Column(name = "tenantId")
    @NotNull(message = "Tenant ID cannot be null!")
    @Max(value = 2147483647, message = "Tenant ID is too big!")
    private int tenantID;

    @Column(name = "landlordId")
    @NotNull(message = "Landlord ID cannot be null!")
    @Max(value = 2147483647, message = "Landlord ID is too big!")
    private int landlordID;

    @Column(name = "createdate")
    @NotNull(message = "Date cannot be null!")
    private String createDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "chatsessionId", insertable = false, updatable = false)
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
