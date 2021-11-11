package com.pravin.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.product.entity.Product;
import com.pravin.product.service.ProductService;

@RestController
@RequestMapping("/productapi")
public class Controller {

	@Autowired
	private ProductService service;

	@PostMapping("/createProduct")
	public ResponseEntity<String> createProduct(@RequestBody Product product) {
		return new ResponseEntity<String>(service.createProduct(product), HttpStatus.OK);
	}

}
