package org.icet.service;


import org.icet.model.Customer;

import java.util.List;

public interface CustomerService {
    void addNewCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getByName(String name);

    public boolean deleteById(Long id);

    void updateCustomer(Customer customer);
}
