package com.project.rentalcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.rentalcar.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
	List<Branch> findAllByCityCityId(Integer cityId);
}
