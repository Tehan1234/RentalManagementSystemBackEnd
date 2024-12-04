package org.icet.service;

import org.icet.model.Rental;

import java.util.List;

public interface RentalService {
    void addNewRental(Rental rental);

    List<Rental> getAllRentals();

    void deleteRental(Long rentalId);

    void updateRental(Rental rental);

    Rental getRentalById(Long rentalId);
}
