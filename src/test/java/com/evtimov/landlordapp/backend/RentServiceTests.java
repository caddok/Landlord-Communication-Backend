package com.evtimov.landlordapp.backend;

import com.evtimov.landlordapp.backend.models.Rent;
import com.evtimov.landlordapp.backend.repositories.base.RentRepository;
import com.evtimov.landlordapp.backend.services.RentServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RentServiceTests {
    @Mock
    RentRepository mockRepository;

    @Mock
    RentServiceImpl mockService;

    @InjectMocks
    RentServiceImpl getMockService;

    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyAddFirstRentWorks_whenCalledFromService() {
        Rent rent = mock(Rent.class);
        mockService.addFirstRent(rent);
        verify(mockService,times(1))
                .addFirstRent(rent);
    }
    @Test
    public void verifyAddNextRentWorks_whenCalledFromService() {
        Rent rent = mock(Rent.class);
        mockService.addNextRent(rent);
        verify(mockService,times(1))
                .addNextRent(rent);
    }

    @Test
    public void verifyAddRentWorks_whenCalledFromRepository(){
        Rent rent = mock(Rent.class);
        mockRepository.addRent(rent);
        verify(mockRepository,times(1))
                .addRent(rent);
    }

    @Test
    public void verifyUpdateRentStatusWork_whenCalledFromService(){
        Rent rent = mock(Rent.class);
        mockService.updateRentIsPaidStatus(rent.getRentID());
        verify(mockService,times(1))
                .updateRentIsPaidStatus(rent.getRentID());

    }

    @Test
    public void verifyUpdateRentStatusWorks_whenCalledFromRepository(){
        Rent rent = mock(Rent.class);
        mockRepository.updateRentIsPaidStatus(rent.getRentID());
        verify(mockRepository,times(1))
                .updateRentIsPaidStatus(rent.getRentID());
    }

    @Test
    public void verifyUpdateRentRemainingWorks_whenCalledFromService(){
        Rent rent = mock(Rent.class);
        mockService.editRent(rent,rent.getRentID());
        verify(mockService,times(1))
                .editRent(rent,rent.getRentID());
    }
    @Test
    public void verifyUpdateRentRemainingWorks_whenCalledFromRepository(){
        Rent rent = mock(Rent.class);
        mockRepository.editRent(rent,rent.getRentID());
        verify(mockRepository,times(1))
                .editRent(rent,rent.getRentID());
    }

    @Test
    public void getRentByPlaceId_shouldReturn_rentForSpecificId(){
        Rent rent = new Rent(200,200,false,"10/10/2010",1);
        Rent rent2 = new Rent(200,200,false,"10/10/2010",2);
        Rent rent3 = new Rent(200,200,false,"10/10/2010",3);
        Rent rent4 = new Rent(200,200,false,"10/10/2010",4);
        Mockito.when(getMockService.getRentByPlaceId(1))
                .thenReturn(rent);
        List<Rent> rents = Arrays.asList(rent,rent2,rent3,rent4);
        Rent result = getMockService.getRentByPlaceId(1);

        Assert.assertEquals(result, rents.get(0));
    }

}
