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

    @RequestMapping(method = RequestMethod.POST)
    public void addRent(@RequestBody @Valid Rent rent){
        service.addRent(rent);
    }

    @RequestMapping(value = "/updateremaining/{rentIdRemaining}", method = RequestMethod.PUT)
    public Rent updateRentRemaining(@PathVariable(value = "rentIdRemaining") int rentId, @RequestBody @Valid Rent rent){
        service.updateRentRemaining(rentId, rent);

        return rent;
    }

    @RequestMapping(value = "/updatestatus/{rentIdStatus}", method = RequestMethod.PUT)
    public Rent updateRentStatus(@PathVariable(value = "rentIdStatus") int rentId, @RequestBody @Valid Rent rent){
        service.updateRentIsPaidStatus(rentId, rent);

        return rent;
    }
}
