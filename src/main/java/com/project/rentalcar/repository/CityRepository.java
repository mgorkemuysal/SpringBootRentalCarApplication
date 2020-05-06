package com.project.rentalcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.rentalcar.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
