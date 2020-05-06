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

import com.project.rentalcar.dao.CityDAO;
import com.project.rentalcar.model.City;

@RestController
@RequestMapping("/api")
public class CityController {
	
	@Autowired
	CityDAO cityDAO;
	
	// save a city 
	@PostMapping("/city/save")
	public City save(@Valid @RequestBody City city) {
		return cityDAO.save(city);
	}
	
	// get all cities
	@GetMapping("/city/all")
	public List<City> getAll(){
		return cityDAO.findAll();
	}
	
	// get a city by CityID
	@GetMapping("/city/{id}")
	public ResponseEntity<City> getById(@PathVariable(value="id") Integer CityID){
		City city = cityDAO.findOne(CityID);
		if(city == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(city);
	}
	
	// update a city by CityID
	@PutMapping("/city/update/{id}")
	public ResponseEntity<City> update(@PathVariable(value="id") Integer CityID, @Valid @RequestBody City cityDetails){
		City city = cityDAO.findOne(CityID);
		if(city == null) {
			return ResponseEntity.notFound().build();
		}
		city.setCityName(cityDetails.getCityName());
		City updatedCity = cityDAO.save(city);
		return ResponseEntity.ok().body(updatedCity);
	}
	
	// delete a city by CityID
	@DeleteMapping("/city/delete/{id}")
	public ResponseEntity<City> delete(@PathVariable(value="id") Integer CityID){
		City city = cityDAO.findOne(CityID);
		if(city == null) {
			return ResponseEntity.notFound().build();
		}
		cityDAO.delete(city);
		return ResponseEntity.ok().build();
	}
}
