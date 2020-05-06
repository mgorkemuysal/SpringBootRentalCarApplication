package com.project.rentalcar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.rentalcar.dao.CarDAO;
import com.project.rentalcar.model.Car;

@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
	CarDAO carDAO;
	
	// save a car
	@PostMapping("/car/save")
	public Car save(@Valid @RequestBody Car car) {
		return carDAO.save(car);
	}
	
	// get all cars
	@GetMapping("/car/all")
	public List<Car> getAll(){
		return carDAO.findAll();
	}
	
	// get a car by CarID
	@GetMapping("/car/{id}")
	public ResponseEntity<Car> getById(@PathVariable(value="id") Integer carId){
		Car car = carDAO.findOne(carId);
		if(car == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(car);
	}
	
	// get car by BranchID
	@GetMapping("/car/byBranch/{id}")
	public List<Car> findAllByBranchBranchId(@PathVariable(value = "id") Integer branchId){
		return carDAO.findAllByBranchBranchId(branchId);
	}
	
	
	// update a car by CarID
	@PutMapping("/car/update/{id}")
	public ResponseEntity<Car> update(@PathVariable(value="id") Integer carId, @Valid @RequestBody Car carDetails){
		Car car = carDAO.findOne(carId);
		if(car == null) {
			return ResponseEntity.notFound().build();
		}
		car.setBrand(carDetails.getBrand());
		car.setModel(carDetails.getModel());
		car.setPrice(carDetails.getPrice());
		car.setAvailable(carDetails.isAvailable());
		car.setGearType(carDetails.getGearType());
		car.setCarClass(carDetails.getCarClass());
		car.setAC(carDetails.isAC());
		car.setCarsNumber(carDetails.getCarsNumber());
		car.setDoorsNumber(carDetails.getDoorsNumber());
		car.setSeatsNumber(carDetails.getSeatsNumber());
		car.setCarImage(carDetails.getCarImage());
		
		Car updatedCar = carDAO.save(car);
		return ResponseEntity.ok().body(updatedCar);
	}
	
	// delete a car by CarID
	@DeleteMapping("/car/delete/{id}")
	public ResponseEntity<Car> delete(@PathVariable(value="id") Integer carId){
		Car car = carDAO.findOne(carId);
		if(car == null) {
			return ResponseEntity.notFound().build();
		}
		carDAO.delete(car);
		return ResponseEntity.ok().build();
	}
}
