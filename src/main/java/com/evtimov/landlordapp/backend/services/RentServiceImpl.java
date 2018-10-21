package com.evtimov.landlordapp.backend.services;

import com.evtimov.landlordapp.backend.models.Rent;
import com.evtimov.landlordapp.backend.repositories.base.RentRepository;
import com.evtimov.landlordapp.backend.services.base.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RentServiceImpl implements RentService {


    private final RentRepository repository;

    @Autowired
    public RentServiceImpl(RentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Rent addRent(Rent entity)  {

        SimpleDateFormat sm = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = sm.format(entity.getDueDate());
        Date dt = new Date();
        try {
            dt = sm.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        entity.setDueDate(dt);

        repository.addRent(entity);

        return entity;
    }

    @Override
    public Rent updateRentRemaining(int rentId, Rent rent) {
        repository.updateRentRemaining(rentId, rent);

        return rent;
    }

    @Override
    public Rent updateRentIsPaidStatus(int rentId, Rent rent) {
        repository.updateRentIsPaidStatus(rentId, rent);

        return rent;
    }
}
