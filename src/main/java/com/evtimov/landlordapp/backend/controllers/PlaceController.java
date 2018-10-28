package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.DTOmodels.PlaceDTO;
import com.evtimov.landlordapp.backend.models.Place;
import com.evtimov.landlordapp.backend.services.base.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    private final PlaceService service;

    @Autowired
    public PlaceController(PlaceService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Place addLandlordPlace(@RequestBody @Valid Place place){
        service.addLandlordPlace(place);
        return place;
    }

    @RequestMapping(value = "/tenant/{tenantId}", method = RequestMethod.GET)
    public List<PlaceDTO> getAllByTenantId(@PathVariable(value = "tenantId") int tenantId){
        return service.getAllByTenantId(tenantId);
    }

    @RequestMapping(value = "/landlord/{landlordId}", method = RequestMethod.GET)
    public List<PlaceDTO> getAllByLandlordId(@PathVariable(value = "landlordId") int landlordId){
        return service.getAllByLandlordId(landlordId);
    }

    @RequestMapping(value = "/{placeId}", method = RequestMethod.GET)
    public PlaceDTO getPlaceById(@PathVariable(value = "placeId") int placeId){

        return service.getPlaceById(placeId);
    }

    @RequestMapping(value = "/{placeId}", method = RequestMethod.PUT)
    public PlaceDTO updateTenantId(int tenantId, @PathVariable(value = "placeId") int placeId){
        return service.updateTenantId(tenantId, placeId);
    }

    @RequestMapping(value = "/notenant", method = RequestMethod.GET)
    public List<PlaceDTO> getAllPlacesWhereNoTenant(){
        return service.getAllPlacesWhereNoTenant();
    }
}
