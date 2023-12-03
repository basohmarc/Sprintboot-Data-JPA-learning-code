package com.edgconsulting.controller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edgconsulting.controller.model.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository <Categorie, 
Integer> {

}
