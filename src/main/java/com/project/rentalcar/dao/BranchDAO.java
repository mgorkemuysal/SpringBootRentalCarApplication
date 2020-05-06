package com.project.rentalcar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.rentalcar.model.Branch;
import com.project.rentalcar.repository.BranchRepository;

@Service
public class BranchDAO {
	
	@Autowired
	BranchRepository branchRepository;
	
	// save a branch
	public Branch save(Branch branch) {
		return branchRepository.save(branch);
	}
	
	// get all branches
	public List<Branch> findAll(){
		return branchRepository.findAll();
	}
	
	// get a branch by BranchID
	public Branch findOne(Integer BranchID) {
		return branchRepository.findById(BranchID).orElse(null);
	}
	
	// get all branch by CityID
	public List<Branch> findAllByCityCityId(Integer cityId){
		return branchRepository.findAllByCityCityId(cityId);
	}
	
	
	// delete a branch by BranchID
	public void delete(Branch branch) {
		branchRepository.delete(branch);
	}
}
