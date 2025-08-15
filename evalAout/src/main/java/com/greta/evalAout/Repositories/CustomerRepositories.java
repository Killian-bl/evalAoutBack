package com.greta.evalAout.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greta.evalAout.Entity.Customer;

public interface CustomerRepositories extends JpaRepository<Customer, Long> {
    List<Customer> findByEmailContainingIgnoreCase(String email);
}