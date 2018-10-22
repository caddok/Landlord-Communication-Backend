package com.evtimov.landlordapp.backend.services;

import com.evtimov.landlordapp.backend.DTOmodels.PlaceDTO;
import com.evtimov.landlordapp.backend.models.Place;
import com.evtimov.landlordapp.backend.models.Rent;
import com.evtimov.landlordapp.backend.repositories.base.PlaceRepository;
import com.evtimov.landlordapp.backend.services.base.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository repository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Place addLandlordPlace(Place place) {
        repository.addLandlordPlace(place);
        return place;
    }

    @Override
    public PlaceDTO getPlaceById(int placeId) {

        Place place = repository.getPlaceById(placeId);

        PlaceDTO placeDTO = new PlaceDTO();

        placeDTO.setPlaceID(place.getPlaceID());
        placeDTO.setAddress(place.getAddress());
        placeDTO.setDescription(place.getDescription());
        placeDTO.setLandlordID(place.getLandlordID());
        placeDTO.setTenantID(place.getTenantID());
        if(place.getRents() != null){
            for (Rent rent:place.getRents()) {
                placeDTO.getRents().add("Total amount: " + rent.getTotalAmount() + "\n" + " Remaining: "
                        + rent.getRemaining() + "\n" + "Due date: "
                        + rent.getDueDate() + "\n" + "Paid: " + rent.getIsPaid() + "\n");
            }
        }

        return placeDTO;
    }


    @Override
    public List<PlaceDTO> getAllByTenantId(int tenantId) {
        List<Place> places = repository.getAllByTenantId(tenantId);
        List<PlaceDTO> placesDTO = new ArrayList<>();

        for (Place place:places) {
            PlaceDTO placeDTO = new PlaceDTO();
            placeDTO.setPlaceID(place.getPlaceID());
            placeDTO.setAddress(place.getAddress());
            placeDTO.setDescription(place.getDescription());
            placeDTO.setLandlordID(place.getLandlordID());
            placeDTO.setTenantID(place.getTenantID());
            if(place.getRents() != null){
                for (Rent rent:place.getRents()) {
                    placeDTO.getRents().add("Total amount: " + rent.getTotalAmount() + "\n" + " Remaining: "
                            + rent.getRemaining() + "\n" + "Due date: "
                            + rent.getDueDate() + "\n" + "Paid: " + rent.getIsPaid() + "\n");
                }
            }
            placesDTO.add(placeDTO);
        }

        return placesDTO;
    }

    @Override
    public List<PlaceDTO> getAllByLandlordId(int landlordId) {
        List<Place> places = repository.getAllByLandlordId(landlordId);
        List<PlaceDTO> placesDTO = new ArrayList<>();

        for (Place place:places) {
            PlaceDTO placeDTO = new PlaceDTO();
            placeDTO.setPlaceID(place.getPlaceID());
            placeDTO.setAddress(place.getAddress());
            placeDTO.setDescription(place.getDescription());
            placeDTO.setLandlordID(place.getLandlordID());
            placeDTO.setTenantID(place.getTenantID());
            if(place.getRents() != null){
                for (Rent rent:place.getRents()) {
                    placeDTO.getRents().add("Total amount: " + rent.getTotalAmount() + "\n" + " Remaining: "
                            + rent.getRemaining() + "\n" + "Due date: "
                            + rent.getDueDate() + "\n" + "Paid: " + rent.getIsPaid() + "\n");
                }
            }
            placesDTO.add(placeDTO);
        }

        return placesDTO;
    }


}
