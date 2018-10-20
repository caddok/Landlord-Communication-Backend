package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Rent;

public interface RentService {

    Rent addRent(Rent rent);

    void updateRentRemaining(int rentId, double remain);

    void updateRentIsPaidStatus(int rentId, boolean isPaid);

}
