package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.models.Rent;
import com.evtimov.landlordapp.backend.services.base.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rents")
public class RentController {

    private final RentService service;

    @Autowired
    public RentController(RentService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addRent(@RequestBody Rent rent){
        service.addRent(rent);
    }

    @RequestMapping(value = "/{rentId}", method = RequestMethod.PUT)
    public Rent updateRent(@PathVariable(value = "rentId") int rentId, @RequestBody Rent rent){
        service.updateRent(rentId, rent);

        return rent;
    }
}
