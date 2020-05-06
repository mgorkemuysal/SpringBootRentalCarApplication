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

import com.project.rentalcar.dao.BranchDAO;
import com.project.rentalcar.model.Branch;

@RestController
@RequestMapping("/api")
public class BranchController {
	
	@Autowired
	BranchDAO branchDAO;
	
	// save a branch
	@PostMapping("/branch/save")
	public Branch save(@Valid @RequestBody Branch branch) {
		return branchDAO.save(branch);
	}
	
	// get all branches
	@GetMapping("/branch/all")
	public List<Branch> getAll(){
		return branchDAO.findAll();
	}
	
	// get a branch by BranchID
	@GetMapping("/branch/{id}")
	public ResponseEntity<Branch> getById(@PathVariable(value="id") Integer BranchID){
		Branch branch = branchDAO.findOne(BranchID);
		if(branch == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(branch);
	}
	
	// get all branch by CityID
	@GetMapping("/branch/byCity/{id}")
	public List<Branch> findAllByCityCityId(@PathVariable(value = "id") Integer cityId){
		return branchDAO.findAllByCityCityId(cityId);
	}
	
	
	// update a branch by BranchID
	@PutMapping("/branch/update/{id}")
	public ResponseEntity<Branch> update(@PathVariable(value="id") Integer BranchID, @Valid @RequestBody Branch branchDetails){
		Branch branch = branchDAO.findOne(BranchID);
		if(branch == null) {
			return ResponseEntity.notFound().build();
		}
		branch.setBranchName(branchDetails.getBranchName());
		Branch updatedBranch = branchDAO.save(branch);
		return ResponseEntity.ok().body(updatedBranch);
	}
	
	// delete a branch by BranchID
	@DeleteMapping("/branch/delete/{id}")
	public ResponseEntity<Branch> delete(@PathVariable(value="id") Integer BranchID){
		Branch branch = branchDAO.findOne(BranchID);
		if(branch == null) {
			return ResponseEntity.notFound().build();
		}
		branchDAO.delete(branch);
		return ResponseEntity.ok().build();
	}
}
