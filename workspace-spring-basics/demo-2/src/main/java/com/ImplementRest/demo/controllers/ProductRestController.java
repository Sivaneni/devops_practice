package com.ImplementRest.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ImplementRest.demo.entities.Product;
import com.ImplementRest.demo.repos.ProductRepository;

import jakarta.persistence.Cacheable;

@RestController
public class ProductRestController {
	@Autowired
	ProductRepository repository;
	
	@RequestMapping(value = "/products/",method=RequestMethod.GET)
	public List<Product> getProducts(){
		
		
		return repository.findAll();
	}
	
	
	@RequestMapping(value = "/products/{id}",method=RequestMethod.GET)
	@Transactional(readOnly = true)
	@org.springframework.cache.annotation.Cacheable("product-cache")
	public Product getProduct(@PathVariable("id") int id) {
		
		return repository.findById(id).get();
		
		
	}
	@RequestMapping(value = "/products/",method=RequestMethod.POST
			
			
			)
	public Product createProduct(@RequestBody Product product) {
		
		return repository.save(product);
		
		
		
	}
	
	@RequestMapping(value = "/products/",method=RequestMethod.PUT)
	public Product updateProduct(Product product) {
		
		return repository.save(product);
		
		
		
	}
	
	@RequestMapping(value = "/products/{id}",method=RequestMethod.DELETE)
	@CacheEvict("product-cache")
	public void deleteProduct(@PathVariable("id") int id) {
		
		repository.deleteById(id);
		
		
	}
	
	
	
 }
