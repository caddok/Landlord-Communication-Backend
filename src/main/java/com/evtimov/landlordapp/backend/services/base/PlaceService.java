package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.DTOmodels.PlaceDTO;
import com.evtimov.landlordapp.backend.models.Place;

import java.util.List;

public interface PlaceService {

    Place addLandlordPlace(Place place);

    List<PlaceDTO> getAllByTenantId(int tenantId);

    List<PlaceDTO> getAllByLandlordId(int landlordId);
}
