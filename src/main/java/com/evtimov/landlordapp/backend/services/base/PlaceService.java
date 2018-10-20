package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Place;

import java.util.List;

public interface PlaceService {

    Place addPlace(Place place);

    List<Place> getAllByTenantId(int tenantId);

    List<Place> getAllByLandlordId(int landlordId);
}
