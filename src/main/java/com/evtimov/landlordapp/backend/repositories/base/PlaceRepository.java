package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.Place;

import java.util.List;

public interface PlaceRepository {

    Place addLandlordPlace(Place place);

    List<Place> getAllByTenantId(int tenantId);

    Place updateTenantId(Place place, int placeId);

    List<Place> getAllPlacesWhereNoTenant();

    List<Place> getAllPlacesByUserId(int userId);

    List<Place> getAllByTenantIdAndLandlordId(int tenantId, int landlordId);
}
