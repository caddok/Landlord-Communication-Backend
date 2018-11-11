package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Rent;

public interface RentService {

    Rent addNextRent(Rent rent);

    Rent addFirstRent(Rent rent);

    Rent updateRentRemaining(int rentId, Rent rent);

    Rent updateRentIsPaidStatus(int rentId);

    Rent getRentByPlaceId(int placeId);

    Rent editRent(Rent rent, int rentId);

}
