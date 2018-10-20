package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.Place;

import java.util.List;

public interface PlaceRepository {

    Place addPlace(Place place);


    List<Place> getAllByTenantId(int tenantId);

    List<Place> getAllByLandlordId(int landlordId);
}
