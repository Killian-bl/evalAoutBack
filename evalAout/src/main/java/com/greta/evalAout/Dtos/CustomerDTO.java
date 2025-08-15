package com.greta.evalAout.Dtos;

import com.greta.evalAout.Entity.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomerDTO {
    
    private Long customerId;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private Long orderId;

    public CustomerDTO(Customer customer) {
        this.email = customer.getEmail();
    }

    public CustomerDTO() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
