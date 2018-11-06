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
    public List<Rating> getRatingsByUserUd(int userId) {
        return repository.getRatingsByUserUd(userId);
    }

    @Override
    public Rating isVotedTwoTimes(int voteForId, int voteFromId) {

        return repository.isVotedTwoTimes(voteForId, voteFromId);
    }
}
