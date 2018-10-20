package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Rent;

public interface RentService {

    Rent addRent(Rent entity);

    Rent updateRent(int rentId, Rent model);


}
