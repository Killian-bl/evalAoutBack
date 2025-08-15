package com.greta.evalAout.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greta.evalAout.Entity.Product;


public interface  ProductRepositories extends JpaRepository<Product, Long>{
    List<Product> findByNameContainingIgnoreCase(String name);
}
