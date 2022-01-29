package com.revature.projects.shopper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.projects.shopper.interfaces.ProductServiceInterface;
import com.revature.projects.shopper.model.PrdouctsEntity;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductServiceInterface productServiceInterface;
	@PostMapping("/add-product")
	public int addProduct(@RequestBody PrdouctsEntity product) {
		
		int result = productServiceInterface.addProduct(product);
		System.out.println(result);
		return result;
	}

}
