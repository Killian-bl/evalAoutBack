package com.greta.evalAout.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greta.evalAout.Dtos.CustomerDTO;
import com.greta.evalAout.Entity.Customer;
import com.greta.evalAout.Repositories.CustomerRepositories;

@Service
public class CustomerService {
    
    private final CustomerRepositories customerRepositories;

    public CustomerService(CustomerRepositories customerRepositories) {
        this.customerRepositories = customerRepositories;
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepositories.findByEmailContainingIgnoreCase(email)
        .stream().findFirst().orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
    }

    public List<Customer> searchCustomer(String email) {
        return customerRepositories.findByEmailContainingIgnoreCase(email);
    }

    public List<Customer> deleteCustomer(Long customerId) {
        customerRepositories.deleteById(customerId);
        return customerRepositories.findAll();
    }

    public Customer updateCustomer(Long customerId, CustomerDTO dto) {
        Customer customer = customerRepositories.findById(customerId)
        .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
        customer.setEmail(dto.getEmail());
        return customerRepositories.save(customer);
    }

    public Customer createCustomer(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setEmail(dto.getEmail());
        return customerRepositories.save(customer);
    }
}
