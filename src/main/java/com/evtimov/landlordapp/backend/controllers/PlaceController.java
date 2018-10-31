package com.evtimov.landlordapp.backend.controllers;


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
    public List<Place> getAllByTenantId(@PathVariable(value = "tenantId") int tenantId){
        return service.getAllByTenantId(tenantId);
    }

    @RequestMapping(value = "/landlord/{landlordId}", method = RequestMethod.GET)
    public List<Place> getAllByLandlordId(@PathVariable(value = "landlordId") int landlordId){
        return service.getAllByLandlordId(landlordId);
    }

    @RequestMapping(value = "/{placeId}", method = RequestMethod.GET)
    public Place getPlaceById(@PathVariable(value = "placeId") int placeId){

        return service.getPlaceById(placeId);
    }

    @RequestMapping(value = "/place/{placeId}", method = RequestMethod.PUT)
    public Place updateTenantId(@RequestBody Place place, @PathVariable(value = "placeId") int placeId){
        return service.updateTenantId(place, placeId);
    }

    @RequestMapping(value = "/notenant", method = RequestMethod.GET)
    public List<Place> getAllPlacesWhereNoTenant(){
        return service.getAllPlacesWhereNoTenant();
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public List<Place> getAllByUserId(@PathVariable(value = "userId") int userId){
        return service.getAllPlacesByUserId(userId);
    }
}
