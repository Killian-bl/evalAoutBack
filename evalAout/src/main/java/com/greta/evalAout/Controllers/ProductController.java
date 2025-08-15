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

import com.greta.evalAout.Dtos.ProductDTO;
import com.greta.evalAout.Entity.Product;
import com.greta.evalAout.Service.ProductService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/product")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String name) {
        List<Product> product = productService.searchProduct(name);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{productId}/product")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("product/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long productId, @Valid @RequestBody ProductDTO dto) {
        Product updated = productService.updateProduct(productId, dto);
        return ResponseEntity.ok(new ProductDTO(updated));
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO dto) {
        Product product = productService.createProduct(dto);
        return ResponseEntity.ok(new ProductDTO(product));
    }
    
}
