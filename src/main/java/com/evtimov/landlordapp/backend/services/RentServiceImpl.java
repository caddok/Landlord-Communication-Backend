package com.evtimov.landlordapp.backend.services;

import com.evtimov.landlordapp.backend.models.Rent;
import com.evtimov.landlordapp.backend.repositories.base.RentRepository;
import com.evtimov.landlordapp.backend.services.base.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentServiceImpl implements RentService {


    private final RentRepository repository;

    @Autowired
    public RentServiceImpl(RentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Rent addRent(Rent entity) {
        repository.addRent(entity);

        return entity;
    }

    @Override
    public Rent updateRent(int rentId, Rent model) {
        repository.updateRent(rentId, model);

        return model;
    }
}
