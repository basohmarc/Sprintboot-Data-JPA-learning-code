package com.edgconsulting.controller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.edgconsulting.controller.model.Product;
import com.edgconsulting.controller.repository.ProductRepository;


 
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Iterable <Product> getProducts() {
		return productRepository.findAll();
		
	}
	
	public Optional <Product> getProductById (Integer id){
		return productRepository.findById(id);
	}
	
	public Product addProduct (Product product) {
		return productRepository.save(product);
	}

}


