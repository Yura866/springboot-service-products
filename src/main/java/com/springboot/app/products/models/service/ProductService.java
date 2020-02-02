package com.springboot.app.products.models.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.app.products.models.entity.Product;


public interface ProductService {
	
	public List <Product> findAll();
	public Product findById(Long id);

}
