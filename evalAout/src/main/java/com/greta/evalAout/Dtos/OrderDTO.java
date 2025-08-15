package com.greta.evalAout.Dtos;

import com.greta.evalAout.Entity.Order;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class OrderDTO {
    
    private Long orderId;

    @NotBlank
    private Integer date;

    @NotBlank
    @Positive
    private Integer cartPrice;

    @NotBlank
    @Positive
    private Integer productNumber;

    @NotNull
    private Long customerId;

    @NotEmpty
    @Size(min = 1)
    private Set<Long> productId;

    public OrderDTO(Order order) {
        this.date = order.getDate();
        this.cartPrice = order.getCartPrice();
        this.productNumber = order.getProductNumber();
    }

    public OrderDTO() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Integer cartPrice) {
        this.cartPrice = cartPrice;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Set<Long> getProductId() {
        return productId;
    }

    public void setProductId(Set<Long> productId) {
        this.productId = productId;
    }
}
