package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.DTOmodels.PlaceDTO;
import com.evtimov.landlordapp.backend.models.Place;
import com.evtimov.landlordapp.backend.services.base.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Place addLandlordPlace(@RequestBody Place place){
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
}
