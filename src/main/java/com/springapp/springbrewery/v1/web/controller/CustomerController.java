package com.springapp.springbrewery.v1.web.controller;

import com.springapp.springbrewery.v1.services.CustomerService;
import com.springapp.springbrewery.v1.web.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Long customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO, UriComponentsBuilder uriComponentsBuilder) {
        CustomerDTO savedCustomer = customerService.createCustomer(customerDTO);
        UriComponents uriComponents = uriComponentsBuilder.path("/api/v1/customer/{id}").buildAndExpand(savedCustomer.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        headers.add("IDE", "IntelliJ");

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity udpateCustomerById(@RequestBody CustomerDTO customerDTO, @PathVariable("id") Long customerId) {
        customerService.updateCustomer(customerDTO, customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
    }

}
