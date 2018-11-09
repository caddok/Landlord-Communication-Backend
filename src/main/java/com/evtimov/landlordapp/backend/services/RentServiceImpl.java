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
    public Rent addNextRent(Rent entity)  {
        String date = dateProvider.getDateAfterOneMonth(entity.getDueDate());
        entity.setDueDate(date);
        return repository.addRent(entity);
    }

    @Override
    public Rent addFirstRent(Rent rent) {
        return repository.addRent(rent);
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

    @Override
    public Rent editRent(Rent rent, int rentId) {
        return repository.editRent(rent, rentId);
    }
}
