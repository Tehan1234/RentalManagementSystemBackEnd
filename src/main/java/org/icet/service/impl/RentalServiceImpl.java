package org.icet.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.entity.RentalEntity;
import org.icet.model.Rental;
import org.icet.repository.RentalRepository;
import org.icet.service.RentalService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor

public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;

    private final ModelMapper modelMapper;

    @Override
    public void addNewRental(Rental rental) {
        rentalRepository.save(modelMapper.map(rental, RentalEntity.class));

    }

    @Override
    public List<Rental> getAllRentals() {
        List<Rental> rentalList = new ArrayList<>();
        rentalRepository.findAll().forEach(rentalEntity -> {
            rentalList.add(modelMapper.map(rentalEntity, Rental.class));
        });
        return rentalList;
    }

    @Override
    public void deleteRental(Long rentalId) {
        rentalRepository.deleteById(rentalId);
    }

    @Override
    public void updateRental(Rental rental) {
        rentalRepository.save(modelMapper.map(rental, RentalEntity.class));
    }

    @Override
    public Rental getRentalById(Long rentalId) {
        return modelMapper.map(rentalRepository.findById(rentalId), Rental.class);
    }
}
