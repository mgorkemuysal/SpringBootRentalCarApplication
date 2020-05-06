

package com.project.rentalcar.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.rentalcar.dao.CustomerDAO;
import com.project.rentalcar.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerDAO customerDAO;

    // save a customer 
    @PostMapping("/customer/save")
    public Customer save(@Valid @RequestBody Customer customer){
        return customerDAO.save(customer);
    }

    // get all customers
    @GetMapping("/customer/all")
    public List<Customer> getAll(){
        return customerDAO.findAll();
    }

    // get a customer by customerId
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getById(@PathVariable(value = "id") Integer customerId){
        Customer customer = customerDAO.findOne(customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(customer);
    }

    // get last record by customerId
    @GetMapping("/customer/last")
    public List<Customer> getLastCustomer(){
        return customerDAO.getLastCustomer();
    }

    // update a customer by customerId
    @PutMapping("/customer/update/{id}")
    public ResponseEntity<Customer> update(@PathVariable(value = "id") Integer customerId, @Valid @RequestBody Customer customerDetails){
        Customer customer = customerDAO.findOne(customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        customer.setName(customerDetails.getName());
        customer.setSurname(customerDetails.getSurname());
        customer.setEmail(customerDetails.getEmail());
        customer.setTcNumber(customerDetails.getTcNumber());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.setAddress(customerDetails.getAddress());
        customer.setTitle(customerDetails.getTitle());
        customer.setCompanyName(customerDetails.getCompanyName());
        Customer updatedCustomer = customerDAO.save(customer);
        return ResponseEntity.ok().body(updatedCustomer);

    }


    
}