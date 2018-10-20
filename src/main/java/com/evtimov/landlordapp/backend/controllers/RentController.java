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

    @RequestMapping(value = "/{rentIdRemaining}", method = RequestMethod.PUT)
    public void updateRentRemaining(@PathVariable(value = "rentIdRemaining") int rentId, double remaining){
        service.updateRentRemaining(rentId, remaining);
    }

    @RequestMapping(value = "/{rentIdStatus}", method = RequestMethod.PUT)
    public void updateRentStatus(@PathVariable(value = "rentIdStatus") int rentId, boolean status){
        service.updateRentIsPaidStatus(rentId, status);
    }
}
