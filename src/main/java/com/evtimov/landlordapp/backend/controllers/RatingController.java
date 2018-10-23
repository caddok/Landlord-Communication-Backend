package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.models.Rating;
import com.evtimov.landlordapp.backend.services.base.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService service;

    @Autowired
    public RatingController(RatingService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Rating addVote(@RequestBody @Valid Rating rating){
        service.addVote(rating);
        return rating;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<Rating> getRatingsByUserId(@PathVariable(value = "userId") int userId){
        return service.getRatingsByUserUd(userId);
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public boolean isVotedTwoTimes(int voteFor, int voteFrom){
        return service.isVotedTwoTimes(voteFor, voteFrom);
    }
}
