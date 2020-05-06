package com.project.rentalcar.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Cities", catalog="rentalcar")
@EntityListeners(AuditingEntityListener.class)
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cityId;
	
	private String cityName;

	public City(String cityName){
		this.cityName = cityName;
	}

	public City(Integer cityId, String cityName){
		this.cityId = cityId;
		this.cityName = cityName;
	}

	public Integer getCityID() {
		return cityId;
	}

	public void setCityID(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
