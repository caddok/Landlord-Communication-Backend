package com.evtimov.landlordapp.backend.services;

import com.evtimov.landlordapp.backend.models.Place;
import com.evtimov.landlordapp.backend.models.Rent;
import com.evtimov.landlordapp.backend.repositories.base.PlaceRepository;
import com.evtimov.landlordapp.backend.services.base.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository repository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Place addLandlordPlace(Place place) {
        return repository.addLandlordPlace(place);
    }


    @Override
    public List<Place> getAllByTenantId(int tenantId) {
        return repository.getAllByTenantId(tenantId);
    }

    @Override
    public Place updateTenantId(Place place, int placeId) {
        return repository.updateTenantId(place, placeId);
    }

    @Override
    public List<Place> getAllPlacesWhereNoTenant() {
        return repository.getAllPlacesWhereNoTenant();
    }

    @Override
    public List<Place> getAllPlacesByUserId(int userId) {
        return repository.getAllPlacesByUserId(userId);
    }

    @Override
    public List<Place> getAllByTenantIdAndLandlordId(int tenantId, int landlordId) {
        return repository.getAllByTenantIdAndLandlordId(tenantId, landlordId);
    }
}
