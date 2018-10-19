package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportId")
    private int reportID;

    @Column(name = "issue")
    private String issue;

    @Column(name = "placeId")
    private int placeID;

    @Column(name = "userId")
    private int userID;

    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private String picture;

    @Column(name = "date")
    private Date date;

    @Column(name = "isresolved")
    private boolean isResolved;

    @ManyToOne
    @JoinColumn(name = "placeId",insertable = false,updatable = false)
    private com.evtimov.landlordapp.landlordspring.models.Place place;

    @ManyToOne
    @JoinColumn(name = "userId",insertable = false,updatable = false)
    private User user;

    public Report(){
        //default
    }

    public Report(int reportID, String issue, String description, String picture, Date date, boolean isResolved, int placeID, int userID){
        setPlaceID(placeID);
        setUserID(userID);
        setReportID(reportID);
        setIssue(issue);
        setDescription(description);
        setPicture(picture);
        setDate(date);
        setIsResolved(isResolved);
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getIsResolved() {
        return this.isResolved;
    }

    public void setIsResolved(boolean isResolved) {
        this.isResolved = isResolved;
    }

    public com.evtimov.landlordapp.landlordspring.models.Place getPlace() {
        return place;
    }

    public void setPlace(com.evtimov.landlordapp.landlordspring.models.Place place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
