

package com.project.rentalcar.repository;

import com.project.rentalcar.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT * FROM customers ORDER BY customer_id DESC LIMIT 1", nativeQuery = true)
    List<Customer> getLastCustomer();
}