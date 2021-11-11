package com.pravin.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.product.ProductRepository.ProductRepository;
import com.pravin.product.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public String createProduct(Product product) {
		productRepository.save(product);
		return "product saved successfully";
	}

}
