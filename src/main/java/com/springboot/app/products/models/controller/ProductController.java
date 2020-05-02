package com.springboot.app.products.models.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.products.models.entity.Product;
import com.springboot.app.products.models.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;

	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	private List<Product> getList(){		
		return productService.findAll().stream().map(product ->{
			//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			product.setPort(port);
			return product;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/see/{id}")
	private Product detail(@PathVariable Long id) throws Exception{
		Product product = productService.findById(id);
		//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		product.setPort(port);		
/*
		try {
			Thread.sleep(2000L);
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
		
		return product;
	}
	
}
