package org.icet.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.entity.CustomerEntity;
import org.icet.model.Customer;
import org.icet.repository.CustomerRepository;
import org.icet.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;


    @Override
    public void addNewCustomer(Customer customer) {
        customerRepository.save(modelMapper.map(customer, CustomerEntity.class));

    }

    @Override
    public List<Customer> getAllCustomers() {
        List <Customer> customerList = new ArrayList<>();
       customerRepository.findAll().forEach(CustomerEntity ->{
           customerList.add(modelMapper.map(CustomerEntity, Customer.class));
       });

        return customerList;
    }
}