package com.evtimov.landlordapp.backend.services;


import com.evtimov.landlordapp.backend.models.Rating;
import com.evtimov.landlordapp.backend.repositories.base.RatingRepository;
import com.evtimov.landlordapp.backend.services.base.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final
    RatingRepository repository;

    @Autowired
    public RatingServiceImpl(RatingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Rating addVote(Rating rating) {
        return repository.addVote(rating);
    }

    @Override
    public List<Rating> getRatingsByUserId(int userId) {
        return repository.getRatingsByUserId(userId);
    }

    @Override
    public Rating isVotedTwoTimes(int voteForId, int voteFromId) {
        List<Rating> ratings = repository.isVotedTwoTimes(voteForId, voteFromId);

        if(ratings.size() > 0){
            return null;
        }else{
            return new Rating();
        }
    }
}