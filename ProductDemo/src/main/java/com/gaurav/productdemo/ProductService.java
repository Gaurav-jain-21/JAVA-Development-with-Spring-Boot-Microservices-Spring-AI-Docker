package com.gaurav.productdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public void addProduct(Product p){
        repo.save(p);
    }

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProduct(String name){
        for(Product p: repo.findAll()){
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }

    public List<Product> getProductWithText(String str){
        String text= str.toLowerCase();
        List<Product> prods = new ArrayList<>();
        for(Product p : repo.findAll()){
            if(p.getName().contains(text) || p.getType().contains(text) || p.getPlace().contains(text) ){
                prods.add(p);

            }
        }

        return prods;
    }
}
