package com.springboot.app.products.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.app.products.models.entity.Product;


public interface ProductDao extends JpaRepository <Product, Long> {

}
