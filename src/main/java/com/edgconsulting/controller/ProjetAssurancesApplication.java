package com.edgconsulting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edgconsulting.controller.model.Categorie;
import com.edgconsulting.controller.model.Comment;
import com.edgconsulting.controller.model.Product;
import com.edgconsulting.controller.service.CategorieService;
import com.edgconsulting.controller.service.ProductService;

import jakarta.transaction.Transactional;

/*Importation d'une base MySQL en ligne de commande sous Windows
Lancez le shell Windows : Cliquez sur « Démarrer », tapez « cmd » et entrée.
Tapez : C:\Program Files\MySQL\MySQL Server 8.2\bin\mysql.exe -u root -p.*/

@SpringBootApplication
//@ComponentScan({"com.delivery.request"})
//@EntityScan("com.delivery.domain")
//@EnableJpaRepositories("com.delivery.repository")
public class ProjetAssurancesApplication implements CommandLineRunner {
	
	
	
		
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategorieService categorieService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetAssurancesApplication.class, args);
		
	}
	
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Override
	@Transactional
	public void run(String...args) throws Exception {
		
		///////// Ajoutez vos données en BDD (CREATE)
		
		//// 1- Ajouter une categorie
		Categorie categorieToAdd= new Categorie();
		categorieToAdd.setName("Assurance-EDG TRAVEL");
		categorieToAdd.setProducts(null);
		
		categorieService.addCategorie(categorieToAdd);
		
		System.out.println();
		System.out.println("LISTE DES PRODUITS:");
		Iterable <Product> products=productService.getProducts();
		products.forEach(product->System.out.println(product.getName()));
		
		System.out.println();
		
		System.out.println("AFFICHE UN PRODUIT DONT L'ID EST FOURNI:");
		
		Optional <Product> productOpt= productService.getProductById(1);
		
		Product product=productOpt.get();
		
		System.out.println(product.getName());
		
		System.out.println();System.out.println();
		
		System.out.println("AFFICHE DES COMMENTAIRES SUR UN PRODUIT DONT L'ID EST FOURNI:");
		
		List <Comment> comments=product.getComments();
		
		
		comments.forEach(comment->System.out.println(comment.getContenu()));
		
		//System.out.println();System.out.println("FIN CODE");
		
		///////////////////////////////////////////	
		
		System.out.println();
		
		System.out.println("AFFICHE DES CATEGORIES D'UN PRODUIT DONT L'ID EST FOURNI:");
		
		List <Categorie> categoriesOfProd= product.getCategories();
		
		categoriesOfProd.forEach(categorie->System.out.println(categorie.getName()));
		
		//////////////////////////////////////////////////		
		
		System.out.println();
		System.out.println("LISTE DES CATEGORIES:");
		Iterable <Categorie> categories=categorieService.getCategories();
		categories.forEach(categorie->System.out.println(categorie.getName()));
		
		System.out.println();
		
		System.out.println("AFFICHE UNE CATEGORIE DONT L'ID EST FOURNI:");
		
		Optional <Categorie> categoriesOpt= categorieService.getCategoriesByid(1);
		
		Categorie categorie=categoriesOpt.get();
		
		System.out.println(categorie.getName());
		
		System.out.println();System.out.println();
		
		System.out.println("AFFICHE DES PRODUITS D'UNE CATEGORIE DONT L'ID EST FOURNI:");
		
		List <Product> produitsOfCat=categorie.getProducts();
		
		
		produitsOfCat.forEach(produit->System.out.println(produit.getName()));
		
		System.out.println();System.out.println("FIN CODE");
		
				
		
	}

}



