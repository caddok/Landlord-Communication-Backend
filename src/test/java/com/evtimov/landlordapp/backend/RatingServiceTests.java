package com.evtimov.landlordapp.backend;

import com.evtimov.landlordapp.backend.models.Rating;
import com.evtimov.landlordapp.backend.repositories.base.RatingRepository;
import com.evtimov.landlordapp.backend.services.PlaceServiceImpl;
import com.evtimov.landlordapp.backend.services.RatingServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class RatingServiceTests {
    @Mock
    RatingRepository mockRepository;

    @InjectMocks
    RatingServiceImpl mockService;

    @Mock
    RatingServiceImpl getMockService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyRepositoryExecutes_addVote_whenCalled(){
        Rating rating = mock(Rating.class);
        mockRepository.addVote(rating);
        Mockito.verify(mockRepository,times(1))
                .addVote(rating);
    }

    @Test
    public void addRating_addsRating_toCollection() {
        Rating rating = mock(Rating.class);
        getMockService.addVote(rating);
        Mockito.verify(getMockService,times(1))
                .addVote(rating);
    }

    @Test
    public void getRatingForSpecificId_shouldReturnRating_forSpecificIdThatWasVotedFor(){
        Mockito.when(mockService.getRatingsByUserId(1))
                .thenReturn(
                        Arrays.asList(
                                new Rating(1,2,2.3),
                                new Rating(1,3,2.7),
                                new Rating(1,4,3.0)
                        )
                );
        List<Rating> result = mockService.getRatingsByUserId(1);

        Assert.assertEquals(3,result.size());
    }

    @Test
    public void isVotedTwoTimes_shouldFail_ifOneUserVotedTwice() {
        final int[] count = {0};
        List<Rating> ratingList = Arrays.asList(
                new Rating(1,2,1.0),
                new Rating(1,2,2.0),
                new Rating(1,3,3.0)
        );
        ratingList.forEach(rating -> {
            if (rating.getVoteFrom() == 2) {
                count[0]++;
            }
        });
        Assert.assertEquals(1, count[0]);
    }
    @Test
    public void isVotedTwoTimes_shouldBeSuccessful_ifEveryUserVotedOnce() {
        final int[] count = {0};
        List<Rating> ratingList = Arrays.asList(
                new Rating(1,2,1.0),
                new Rating(1,4,2.0),
                new Rating(1,3,3.0)
        );
        ratingList.forEach(rating -> {
            if (rating.getVoteFrom() == 2) {
                count[0]++;
            }
        });
        Assert.assertEquals(1, count[0]);
    }
}
