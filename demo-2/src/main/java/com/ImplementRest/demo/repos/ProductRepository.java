package com.ImplementRest.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ImplementRest.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
