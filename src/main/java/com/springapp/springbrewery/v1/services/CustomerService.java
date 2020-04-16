package com.springapp.springbrewery.v1.services;

import com.springapp.springbrewery.v1.web.model.CustomerDTO;

public interface CustomerService {

    CustomerDTO getCustomerById(Long customerId);

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO, Long customerId);

    void deleteCustomer(Long customerId);
}
