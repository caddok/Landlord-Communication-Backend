package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Place;

import java.util.List;

public interface PlaceService {

    Place addLandlordPlace(Place place);

    Place getPlaceById(int placeId);

    List<Place> getAllByTenantId(int tenantId);

    List<Place> getAllByLandlordId(int landlordId);

    Place updateTenantId(Place place, int placeId);

    List<Place> getAllPlacesWhereNoTenant();

    List<Place> getAllPlacesByUserId(int userId);
}
