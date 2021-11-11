package com.pravin.product.ProductRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.product.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{


}
