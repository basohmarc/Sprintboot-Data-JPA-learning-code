package com.edgconsulting.controller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgconsulting.controller.model.Categorie;
import com.edgconsulting.controller.model.Product;
import com.edgconsulting.controller.repository.CategorieRepository;

@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	public Iterable <Categorie> getCategories(){
		return categorieRepository.findAll();
	}
	
	public Optional <Categorie> getCategoriesByid (Integer Id){
		return categorieRepository.findById(Id);
	}
	
	public Categorie addCategorie (Categorie category) {
		return categorieRepository.save(category);
	}

}
