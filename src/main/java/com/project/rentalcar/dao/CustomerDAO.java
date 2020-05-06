

package com.project.rentalcar.dao;

import java.util.List;

import com.project.rentalcar.model.Customer;
import com.project.rentalcar.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDAO {

    @Autowired
    CustomerRepository customerRepository;

    // save a customer
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    // get all customers
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }  

    // get a customer by customerId
    public Customer findOne(Integer customerId){
        return customerRepository.findById(customerId).orElse(null);
    }

    public List<Customer> getLastCustomer(){
        return customerRepository.getLastCustomer();
    }

}