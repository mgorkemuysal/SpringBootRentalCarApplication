package com.project.rentalcar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.rentalcar.model.City;
import com.project.rentalcar.repository.CityRepository;

@Service
public class CityDAO {
	
	@Autowired
	CityRepository cityRepository;
	
	// save a city
	public City save(City city) {
		return cityRepository.save(city);
	}
	
	// get all cities
	public List<City> findAll(){
		return cityRepository.findAll();
	}
	
	// get a city by CityID
	public City findOne(Integer CityID) {
		return cityRepository.findById(CityID).orElse(null);
	}
	
	// delete a city by CityID
	public void delete(City city) {
		cityRepository.delete(city);
	}
}
