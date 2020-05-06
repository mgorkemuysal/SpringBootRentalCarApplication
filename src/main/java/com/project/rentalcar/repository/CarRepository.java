package com.project.rentalcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.project.rentalcar.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	List<Car> findAllByBranchBranchId(Integer branchId);
} 
