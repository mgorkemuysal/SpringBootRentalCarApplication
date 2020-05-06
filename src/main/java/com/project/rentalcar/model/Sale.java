

package com.project.rentalcar.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Sales", catalog = "rentalcar")
@EntityListeners(EntityListeners.class)
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saleId;

    private Date fromDate;

    private Date toDate;

    private Integer saledCarsNumber;

    private Integer totalPayment;

    private boolean paid;

    private boolean active;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    
    @OneToOne
    @JoinColumn(name = "carId")
    private Car car;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getSaledCarsNumber() {
        return saledCarsNumber;
    }

    public void setSaledCarsNumber(Integer saledCarsNumber) {
        this.saledCarsNumber = saledCarsNumber;
    }

    public Integer getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Integer totalPayment) {
        this.totalPayment = totalPayment;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}