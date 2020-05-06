package com.project.rentalcar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.rentalcar.model.Car;
import com.project.rentalcar.repository.CarRepository;

@Service
public class CarDAO {
	
	@Autowired
	CarRepository carRepository;
	
	// save a car
	public Car save(Car car) {
		return carRepository.save(car);
	}
	
	// get all cars 
	public List<Car> findAll(){
		return carRepository.findAll();	
	}
	
	// get a car by CarID
	public Car findOne(Integer carId) {
		return carRepository.findById(carId).orElse(null);
	}
	
	// get car by BranchID
	public List<Car> findAllByBranchBranchId(Integer branchId){
		return carRepository.findAllByBranchBranchId(branchId);
	}
	
	// delete a car by CarID
	public void delete(Car car) {
		carRepository.delete(car);
	}
}
