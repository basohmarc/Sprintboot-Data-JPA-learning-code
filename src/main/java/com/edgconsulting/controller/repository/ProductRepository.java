package com.edgconsulting.controller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edgconsulting.controller.model.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product,Integer> {

}
