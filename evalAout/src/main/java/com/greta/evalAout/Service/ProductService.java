package com.greta.evalAout.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greta.evalAout.Dtos.ProductDTO;
import com.greta.evalAout.Entity.Product;
import com.greta.evalAout.Repositories.ProductRepositories;

@Service
public class ProductService {
    
    private final ProductRepositories productRepositories;

    public ProductService(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    public Product getProductByName(String name) {
        return productRepositories.findByNameContainingIgnoreCase(name)
        .stream().findFirst().orElseThrow(() -> new RuntimeException("Produit introuvable"));
    }

    public List<Product> getAllProduct() {
        return productRepositories.findAll();
    }

    public List<Product> searchProduct(String name) {
        return productRepositories.findByNameContainingIgnoreCase(name);
    }

    public List<Product> deleteProduct(Long productId) {
        productRepositories.deleteById(productId);
        return productRepositories.findAll();
    }

    public Product updateProduct(Long productId, ProductDTO dto) {
        Product product = productRepositories.findById(productId)
        .orElseThrow(() -> new RuntimeException("Produit introuvable"));
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setOverview(dto.getOverview());
        return productRepositories.save(product);
    }

    public Product createProduct(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setOverview(dto.getOverview());
        return productRepositories.save(product);
    }
}
