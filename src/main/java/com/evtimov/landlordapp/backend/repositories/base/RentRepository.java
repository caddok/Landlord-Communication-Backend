package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.Rent;

public interface RentRepository {

    Rent addRent(Rent rent);

    Rent updateRentRemaining(int rentId, double remain);

    Rent updateRentIsPaidStatus(int rentId, boolean isPaid);
}
