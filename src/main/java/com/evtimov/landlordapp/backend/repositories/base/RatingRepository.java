package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.Rating;

import java.util.List;

public interface RatingRepository {

    Rating addVote(Rating rating);

    List<Rating> getRatingsByUserUd(int userId);

    boolean isVotedTwoTimes(int voteFor, int voteFrom);
}
