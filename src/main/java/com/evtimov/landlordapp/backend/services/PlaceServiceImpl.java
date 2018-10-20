package com.evtimov.landlordapp.backend.services;

import com.evtimov.landlordapp.backend.models.Place;
import com.evtimov.landlordapp.backend.repositories.base.PlaceRepository;
import com.evtimov.landlordapp.backend.services.base.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository repository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Place addPlace(Place place) {
        repository.addPlace(place);
        return place;
    }


    @Override
    public List<Place> getAllByTenantId(int tenantId) {
        return repository.getAllByTenantId(tenantId);
    }

    @Override
    public List<Place> getAllByLandlordId(int landlordId) {
        return repository.getAllByLandlordId(landlordId);
    }
}
