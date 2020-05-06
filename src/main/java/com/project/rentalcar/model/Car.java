package com.project.rentalcar.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Cars", catalog="rentalcar")
@EntityListeners(AuditingEntityListener.class)
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer carId;
	
	private String brand;
	
	private String model;
	
	private double price;
	
	private boolean available;
	
	private String gearType;
	
	private String fuelType;
	
	private String carClass;
	
	private boolean aC;
	
	private Integer carsNumber;
	
	private Integer doorsNumber;
	
	private Integer seatsNumber;
	
	private String carImage;
	
	@ManyToOne
	@JoinColumn(name="branchId")
	private Branch branch;
	

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Integer getCarID() {
		return carId;
	}

	public void setCarID(Integer carId) {
		this.carId = carId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getGearType() {
		return gearType;
	}

	public void setGearType(String gearType) {
		this.gearType = gearType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getCarClass() {
		return carClass;
	}

	public void setCarClass(String carClass) {
		this.carClass = carClass;
	}

	public boolean isAC() {
		return aC;
	}

	public void setAC(boolean aC) {
		this.aC = aC;
	}

	public Integer getCarsNumber() {
		return carsNumber;
	}

	public void setCarsNumber(Integer carsNumber) {
		this.carsNumber = carsNumber;
	}

	public Integer getDoorsNumber() {
		return doorsNumber;
	}

	public void setDoorsNumber(Integer doorsNumber) {
		this.doorsNumber = doorsNumber;
	}

	public Integer getSeatsNumber() {
		return seatsNumber;
	}

	public void setSeatsNumber(Integer seatsNumber) {
		this.seatsNumber = seatsNumber;
	}

	public String getCarImage() {
		return carImage;
	}

	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}
	
	
}
