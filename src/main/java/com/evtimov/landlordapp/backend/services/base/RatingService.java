package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Rating;

import java.util.List;

public interface RatingService {

    Rating addVote(Rating rating);

    List<Rating> getRatingsByUserId(int userId);

    Rating isVotedTwoTimes(int voteForId, int voteFromId);
}
