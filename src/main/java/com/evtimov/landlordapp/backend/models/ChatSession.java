package com.evtimov.landlordapp.backend.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "chatsessions")
public class ChatSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatsessionId")
    @NotNull(message = "ChatSession ID cannot be null!")
    @Min(value = 1, message = "ChatSession ID must be at least 1!")
    @Max(value = 2147483647, message = "ChatSession ID is too big!")
    private int chatsessionID;

    @Column(name = "tenantId")
    @NotNull(message = "Tenant ID cannot be null!")
    @Min(value = 1, message = "Tenant ID must be at least 1!")
    @Max(value = 2147483647, message = "Tenant ID is too big!")
    private int tenantID;

    @Column(name = "landlordId")
    @NotNull(message = "Landlord ID cannot be null!")
    @Min(value = 1, message = "Landlord ID must be at least 1!")
    @Max(value = 2147483647, message = "Landlord ID is too big!")
    private int landlordID;

    @Column(name = "createdate")
    @NotNull(message = "Date cannot be null!")
    private Date createDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "chatsessionId", insertable = false, updatable = false)
    private Set<Message> messages;


    public ChatSession() {
        //default
    }

    public ChatSession(Date createDate, int tenantID, int landlordID) {
        setTenantID(tenantID);
        setLandlordID(landlordID);
        setCreateDate(createDate);
    }

    public int getChatsessionID() {
        return chatsessionID;
    }

    private void setChatsessionID(int chatsessionID) {
        this.chatsessionID = chatsessionID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    private void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<Message> getMessages() {
        return messages;
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
}
