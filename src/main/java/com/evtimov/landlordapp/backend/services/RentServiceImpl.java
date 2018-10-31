package com.evtimov.landlordapp.backend.services;

import com.evtimov.landlordapp.backend.models.Rent;
import com.evtimov.landlordapp.backend.repositories.base.RentRepository;
import com.evtimov.landlordapp.backend.services.base.RentService;
import com.evtimov.landlordapp.backend.utils.DateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentServiceImpl implements RentService {


    private final RentRepository repository;
    private final DateProvider dateProvider;

    @Autowired
    public RentServiceImpl(RentRepository repository, DateProvider dateProvider) {
        this.repository = repository;
        this.dateProvider = dateProvider;
    }

    @Override
    public Rent addRent(Rent entity)  {
        String date = dateProvider.getDateAfterOneMonth(entity.getDueDate());
        entity.setDueDate(date);
        return repository.addRent(entity);
    }

    @Override
    public Rent updateRentRemaining(int rentId, Rent rent) {
        return repository.updateRentRemaining(rentId, rent);
    }

    @Override
    public Rent updateRentIsPaidStatus(int rentId) {
        return repository.updateRentIsPaidStatus(rentId);
    }

    @Override
    public Rent getRentByPlaceId(int placeId) {
        return repository.getRentByPlaceId(placeId);
    }
}
