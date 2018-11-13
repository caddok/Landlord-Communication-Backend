package com.evtimov.landlordapp.backend;

import com.evtimov.landlordapp.backend.models.Place;
import com.evtimov.landlordapp.backend.repositories.base.PlaceRepository;
import com.evtimov.landlordapp.backend.services.PlaceServiceImpl;
import com.evtimov.landlordapp.backend.services.base.PlaceService;
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
public class PlaceServiceTests {
    @Mock
    PlaceRepository mockRepository;

    @Mock
    PlaceService placeService;

    @InjectMocks
    PlaceServiceImpl mockService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyRepositoryMethod_addLandlordPlace_isExecuted_whenCalled(){
        Place place = mock(Place.class);
        mockRepository.addLandlordPlace(place);
        Mockito.verify(mockRepository,times(1))
                .addLandlordPlace(place);
    }

    @Test
    public void verifyServiceMethodWorks() {
        Place place = mock(Place.class);
        placeService.addLandlordPlace(place);
        Mockito.verify(placeService,times(1))
                .addLandlordPlace(place);
    }

    @Test
    public void getAllByTenantId_shouldReturn_placeForSpecificId(){
        Mockito.when(mockService.getAllByTenantId(1))
                .thenReturn(Arrays.asList(
                        new Place("some address 1","lorem ipsum",1,2),
                        new Place("some address 2","lorem ipsum 1",1,3),
                        new Place("some address 3","lorem ipsum 2",1,4),
                        new Place("some address 4","lorem ipsum 3",1,5)
                ));
        List<Place> result = mockService.getAllByTenantId(1);

        Assert.assertEquals(4,result.size());
    }
    @Test
    public void getAllPlacesByUserId_shouldReturn_placeForSpecificId(){
        Mockito.when(mockService.getAllPlacesByUserId(1))
                .thenReturn(Arrays.asList(
                        new Place("some address 1","lorem ipsum",1,2),
                        new Place("some address 2","lorem ipsum 1",1,3),
                        new Place("some address 3","lorem ipsum 2",1,4),
                        new Place("some address 4","lorem ipsum 3",1,5)
                ));
        List<Place> result = mockService.getAllByTenantId(1);

        Assert.assertEquals(4,result.size());
    }
    //not working gotta fix the repo
    @Test
    public void getAllByTenantIdAndLandlordId_shouldReturn_placeForSpecificTenantAndLandlordId(){
        Mockito.when(mockService.getAllByTenantIdAndLandlordId(1,2))
                .thenReturn(Arrays.asList(
                        new Place("some address 1","lorem ipsum",1,2),
                        new Place("some address 2","lorem ipsum 1",1,2),
                        new Place("some address 3","lorem ipsum 2",1,2),
                        new Place("some address 4","lorem ipsum 3",1,2)
                ));
        List<Place> result = mockService.getAllByTenantIdAndLandlordId(1,2);

        Assert.assertEquals(4,result.size());
    }

    @Test
    public void getAllPlacesWhereNoTenants_shouldReturn_placesWhereTenantIdIs0(){
        Mockito.when(mockService.getAllPlacesWhereNoTenant())
                .thenReturn(Arrays.asList(
                        new Place("some address 1","lorem ipsum",0,2),
                        new Place("some address 2","lorem ipsum 1",0,3),
                        new Place("some address 3","lorem ipsum 2",0,4),
                        new Place("some address 4","lorem ipsum 3",0,5)
                ));
        List<Place> result = mockService.getAllPlacesWhereNoTenant();
        Assert.assertEquals(4, result.size());
    }
}
