package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.Place;

import java.util.List;

public interface PlaceRepository {

    Place addLandlordPlace(Place place);

    Place getPlaceById(int placeId);

    List<Place> getAllByTenantId(int tenantId);

    List<Place> getAllByLandlordId(int landlordId);

    Place updateTenantId(int tenantId, int placeId);
}
