package com.ianfrancisco.desafioanotaai.controllers;

import com.ianfrancisco.desafioanotaai.domain.category.Category;
import com.ianfrancisco.desafioanotaai.domain.category.CategoryDto;
import com.ianfrancisco.desafioanotaai.domain.product.Product;
import com.ianfrancisco.desafioanotaai.domain.product.ProductDto;
import com.ianfrancisco.desafioanotaai.services.CategoryService;
import com.ianfrancisco.desafioanotaai.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDto productData) {
        Product newProduct = this.service.insert(productData);
        return ResponseEntity.ok().body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = this.service.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDto productData) {
        Product newProduct = this.service.update(id, productData);
        return ResponseEntity.ok().body(newProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") String id, @RequestBody ProductDto productData) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
