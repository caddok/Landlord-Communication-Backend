package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;

@Entity
@Table(name = "chatsessionsusers")
public class ChatsessionsUsers {

    @Id
    @Column(name = "chatsessionId")
    private int chatsessionID;

    @Id
    @Column(name = "userId")
    private int userID;

    public ChatsessionsUsers(){
        //default
    }

    public ChatsessionsUsers(int chatsessionID, int userID){
        setChatsessionID(chatsessionID);
        setUserID(userID);
    }

    public int getChatsessionID() {
        return chatsessionID;
    }

    public void setChatsessionID(int chatsessionID) {
        this.chatsessionID = chatsessionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
