package com.evtimov.landlordapp.backend;

import com.evtimov.landlordapp.backend.models.Card;
import com.evtimov.landlordapp.backend.repositories.base.CardRepository;
import com.evtimov.landlordapp.backend.services.CardServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceTests {
    @Mock
    CardRepository mockCardRepository;

    @InjectMocks
    CardServiceImpl mockService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyRepositoryExecutes_addCard_whenCalled() {
        Card card = mock(Card.class);
        mockCardRepository.addCard(card);
        Mockito.verify(mockCardRepository,times(1))
                .addCard(card);
    }

    @Test
    public void verifyRepositoryExecutes_findAllCardsByUserId_whenMethodCalled() {
        mockCardRepository.getAllCardsByUserId(1);
        Mockito.verify(mockCardRepository,times(1))
                .getAllCardsByUserId(1);
    }

    @Test
    public void findAllCardsByUserId_ShouldReturnCards_forSpecificUserId() {
        Mockito.when(mockService.getAllCardsByUserId(1))
                .thenReturn(Arrays.asList(
                        new Card("mastercard",
                                "credit","123458679","111",1000,1),
                        new Card("american express",
                                "credit","123412345","222",1000,1),
                        new Card("visa",
                                "credit","129876545","333",1000,1)
                ));

        List<Card> result = mockService.getAllCardsByUserId(1);

        Assert.assertEquals(3,result.size());
    }

    @Test
    public void verifyRepositoryExecutes_updateCardBalance_whenMethodCalled() {
        Card card = mock(Card.class);
        mockCardRepository.updateCardBalance(1,card);
        Mockito.verify(mockCardRepository,times(1))
                .updateCardBalance(1,card);
    }
}
