package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.models.Rent;
import com.evtimov.landlordapp.backend.services.base.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/rents")
public class RentController {

    private final RentService service;

    @Autowired
    public RentController(RentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/first", method = RequestMethod.POST)
    public void addFirstRent(@RequestBody @Valid Rent rent){
        service.addFirstRent(rent);
    }

    @RequestMapping(value = "/next", method = RequestMethod.POST)
    public void addNextRent(@RequestBody @Valid Rent rent){
        service.addNextRent(rent);
    }

    @RequestMapping(value = "/updateremaining/{rentId}", method = RequestMethod.PUT)
    public Rent updateRentRemaining(@PathVariable(value = "rentId") int rentId, @RequestBody Rent rent){
        return service.updateRentRemaining(rentId, rent);

    }

    @RequestMapping(value = "/updatestatus/{rentId}", method = RequestMethod.PUT)
    public Rent updateRentStatus(@PathVariable(value = "rentId") int rentId){
        return service.updateRentIsPaidStatus(rentId);
    }

    @RequestMapping(value = "/{placeId}", method = RequestMethod.GET)
    public Rent getRentByPlaceId(@PathVariable(value = "placeId") int placeId){
        return service.getRentByPlaceId(placeId);
    }

    @RequestMapping(value = "/edit/{rentId}", method = RequestMethod.PUT)
    public Rent editRent(@PathVariable(value = "rentId") int rentId, @RequestBody Rent rent){
        return service.editRent(rent, rentId);
    }
}
