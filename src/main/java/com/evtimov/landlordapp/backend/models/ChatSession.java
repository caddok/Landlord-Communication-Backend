package com.evtimov.landlordapp.backend.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "chatsessions")
public class ChatSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatsessionId")
    private int chatsessionID;

    @Column(name = "tenantId")
    private int tenantID;

    @Column(name = "landlordId")
    private int landlordID;

    @Column(name = "createdate")
    private Date createDate;

    @OneToMany
    @JoinColumn(name = "chatsessionId")
    private Set<Message> messages;


    public ChatSession() {
        //default
    }

    public ChatSession(int chatsessionID, Date createDate, int tenantID, int landlordID) {
        setTenantID(tenantID);
        setLandlordID(landlordID);
        setChatsessionID(chatsessionID);
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
