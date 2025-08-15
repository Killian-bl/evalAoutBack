package com.greta.evalAout.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greta.evalAout.Dtos.CustomerDTO;
import com.greta.evalAout.Entity.Customer;
import com.greta.evalAout.Service.CustomerService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/customer")
public class CustomerController {
     private final CustomerService customerService;

     public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
     }

     @GetMapping("/customer/search")
     public ResponseEntity<List<Customer>> searchCustomer(@RequestParam String email) {
        List<Customer> customer = customerService.searchCustomer(email);
         return ResponseEntity.ok(customer);
     }

     @DeleteMapping("/{customerId}/customer")
     public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
     }

     @PutMapping("customer/{customerId}")
     public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long customerId, @Valid @RequestBody CustomerDTO dto) {
         Customer updated = customerService.createCustomer(dto);
         return ResponseEntity.ok(new CustomerDTO(updated));
     }

     @PostMapping("/customer")
     public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO dto) {
         Customer customer = customerService.createCustomer(dto);
         return ResponseEntity.ok(new CustomerDTO(customer));
     }

}
