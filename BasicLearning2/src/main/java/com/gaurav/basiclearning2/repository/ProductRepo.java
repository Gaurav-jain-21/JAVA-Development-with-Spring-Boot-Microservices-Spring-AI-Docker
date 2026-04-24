package com.gaurav.basiclearning2.repository;

import com.gaurav.basiclearning2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    void removeByProdId(int prodId);
}
