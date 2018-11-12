package com.evtimov.landlordapp.backend.models;


import com.evtimov.landlordapp.backend.utils.Constants;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = Constants.RATINGS)
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.RATING_ID)
    private int ratingID;

    @Column(name = Constants.VOTE_FOR)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.VOTE_FOR_ID_TOO_BIG)
    @NotNull(message = Constants.VOTE_FOR_ID_NULL)
    private int voteFor;

    @Column(name = Constants.VOTE_FROM)
    @Max(value = Constants.INT_MAX_VALUE, message = Constants.VOTE_FROM_ID_MAX_VALUE_MESSAGE)
    @NotNull(message = Constants.VOTE_FROM_NULL_MESSAGE)
    private int voteFrom;

    @Column(name = Constants.RATING)
    @DecimalMax(value = Constants.RATING_MAX_VALUE, message = Constants.RATING_MAX_VALUE_MESSAGE)
    @DecimalMin(value = Constants.RATING_MIN_VALUE, message = Constants.RATING_MIN_VALUE_MESSAGE)
    @NotNull(message = Constants.RATING_NULL_MESSAGE)
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
