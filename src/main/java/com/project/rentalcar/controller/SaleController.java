

package com.project.rentalcar.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.rentalcar.dao.SaleDAO;
import com.project.rentalcar.model.Sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaleController {

    @Autowired
    SaleDAO saleDAO;

    // save a sale
    @PostMapping("/sale/save")
    public Sale save(@Valid @RequestBody Sale sale){
        return saleDAO.save(sale);
    }

    // get all sales
    @GetMapping("/sale/all")
    public List<Sale> getAll(){
        return saleDAO.findAll();
    }

    // get a sale by saleId
    @GetMapping("/sale/{id}")
    public ResponseEntity<Sale> getById(@PathVariable(value = "id") Integer saleId){
        Sale sale = saleDAO.findOne(saleId);
        if (sale == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(sale);
    }

    // update a sale by saleId
    @PutMapping("/sale/update/{id}")
    public ResponseEntity<Sale> update(@PathVariable(value = "id") Integer saleId, @Valid @RequestBody Sale saleDetails){
        Sale sale = saleDAO.findOne(saleId);
        if (sale == null) {
            ResponseEntity.notFound().build();
        }
        sale.setFromDate(saleDetails.getFromDate());
        sale.setToDate(saleDetails.getToDate());
        sale.setSaledCarsNumber(saleDetails.getSaledCarsNumber());
        sale.setTotalPayment(saleDetails.getTotalPayment());
        sale.setPaid(saleDetails.isPaid());
        sale.setActive(saleDetails.isActive());
        Sale updatedSale = saleDAO.save(sale);
        return ResponseEntity.ok().body(updatedSale);
    }

    // update paid
    @PutMapping("/sale/update/paid/{id}")
    public ResponseEntity<Sale> updatePaid(@PathVariable(value = "id") Integer saleId, @Valid @RequestBody Sale saleDetails){
        Sale sale = saleDAO.findOne(saleId);
        if (sale == null) {
            ResponseEntity.notFound().build();
        }
        sale.setPaid(saleDetails.isPaid());
        Sale updatedPaid = saleDAO.save(sale);
        return ResponseEntity.ok().body(updatedPaid);
    }

    
}