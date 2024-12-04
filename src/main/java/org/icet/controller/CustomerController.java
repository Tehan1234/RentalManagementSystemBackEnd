package org.icet.controller;

import lombok.RequiredArgsConstructor;
import org.icet.model.Customer;
import org.icet.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
@RequiredArgsConstructor

public class CustomerController {

    private final CustomerService customerService;



    @PostMapping("/add-new-customer")
    public void addNewCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
    }

    @GetMapping("/get-all-customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }




}