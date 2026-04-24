package com.gaurav.basiclearning2.controller;

import com.gaurav.basiclearning2.model.Product;
import com.gaurav.basiclearning2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        service.addProduct(prod);
    }
    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }

    @PutMapping("/products")
    public List<Product> updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
        return service.getAllProducts();
    }

}
