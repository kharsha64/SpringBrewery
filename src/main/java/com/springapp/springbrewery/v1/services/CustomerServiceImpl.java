package com.springapp.springbrewery.v1.services;

import com.springapp.springbrewery.v1.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        return CustomerDTO.builder().id(39L).name("John Scott").build();
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder().id(600).build();
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO, Long customerId) {
        log.info("Updating Customer");
    }

    @Override
    public void deleteCustomer(Long customerId) {
        log.info("Deleting Customer");
    }
}
