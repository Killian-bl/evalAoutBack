package com.greta.evalAout.Dtos;

import com.greta.evalAout.Entity.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductDTO {
    
    private Long productId;

    @NotBlank
    private String name;

    @NotBlank
    @Positive
    private Integer price;

    @NotBlank
    private String overview;

    private Integer stock;

    private Integer quantity;

    private Long orderId;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.overview = product.getOverview();
    }

    public ProductDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
