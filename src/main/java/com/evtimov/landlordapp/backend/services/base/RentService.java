package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Rent;

public interface RentService {

    Rent addRent(Rent rent);

    Rent updateRentRemaining(int rentId, Rent rent);

    Rent updateRentIsPaidStatus(int rentId, Rent rent);

}
