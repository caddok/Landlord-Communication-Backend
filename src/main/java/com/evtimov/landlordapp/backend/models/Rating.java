package com.evtimov.landlordapp.backend.models;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingId")
    private int ratingID;

    @Column(name = "voteFor")
    @Min(value = 1, message = "Vote for ID must be at least 1!")
    @Max(value = 2147483647, message = "Vote for ID is too big!")
    @NotNull(message = "Vote for ID cannot be null!")
    private int voteFor;

    @Column(name = "voteFrom")
    @Min(value = 1, message = "Vote from ID must be at least 1!")
    @Max(value = 2147483647, message = "Vote from ID is too big!")
    @NotNull(message = "Vote from ID cannot be null!")
    private int voteFrom;

    @Column(name = "rating")
    @DecimalMax(value = "5.0", message = "Rating is too big!")
    @DecimalMin(value = "0.0", message = "Rating cannot be negative!")
    @NotNull(message = "Rating cannot be null!")
    private double rating;


    public Rating(){
        //default
    }

    public Rating(int voteFor, int voteFrom, double rating){
        setVoteFor(voteFor);
        setVoteFrom(voteFrom);
        setRating(rating);
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public int getVoteFor() {
        return voteFor;
    }

    private void setVoteFor(int voteFor) {
        this.voteFor = voteFor;
    }

    public int getVoteFrom() {
        return voteFrom;
    }

    private void setVoteFrom(int voteFrom) {
        this.voteFrom = voteFrom;
    }

    public double getRating() {
        return rating;
    }

    private void setRating(double rating) {
        this.rating = rating;
    }
}
