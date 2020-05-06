

package com.project.rentalcar.dao;

import java.util.List;

import com.project.rentalcar.model.Sale;
import com.project.rentalcar.repository.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleDAO {

    @Autowired
    SaleRepository saleRepository;

    // save a sale 
    public Sale save(Sale sale){
        return saleRepository.save(sale);
    }

    // get all sales 
    public List<Sale> findAll(){
        return saleRepository.findAll();
    }

    // get a sale by saleId
    public Sale findOne(Integer saleId){
        return saleRepository.findById(saleId).orElse(null);
    }
     
}