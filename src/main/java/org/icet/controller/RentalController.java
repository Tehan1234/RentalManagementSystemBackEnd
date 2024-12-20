package org.icet.controller;

import lombok.RequiredArgsConstructor;
import org.icet.model.Rental;
import org.icet.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rental")
@RequiredArgsConstructor

public class RentalController {

    private final RentalService rentalService;

    private final ItemController itemController;

    @PostMapping("/add-new-rental")
    public void addNewRental(@RequestBody Rental rental) {
       rentalService.addNewRental(rental);

       itemController.changeItemAvailability(rental.getItemId());
    }

    @GetMapping("/get-all-rentals")
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @DeleteMapping("/delete-rental/{rentalId}")
    public void deleteRental(@PathVariable Long rentalId) {
        rentalService.deleteRental(rentalId);
    }

    @PutMapping("/update-rental")
    public void updateRental(@RequestBody Rental rental) {
        rentalService.updateRental(rental);
    }

    @GetMapping("/get-rental-by-id/{rentalId}")
    public Rental getRentalById(@PathVariable Long rentalId) {
        return rentalService.getRentalById(rentalId);
    }

}
