package com.revature.projects.shopper.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.projects.shopper.interfaces.ProductServiceInterface;
import com.revature.projects.shopper.interfaces.SearchServiceInterface;
import com.revature.projects.shopper.model.PrdouctsEntity;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/search-product")
public class SearchController {

	@Autowired
	private SearchServiceInterface searchServiceInterface;
	
	@GetMapping("/get-Singleproduct/{id}")
	public PrdouctsEntity searchProductById(@PathVariable(value = "id") Long productId) {
		PrdouctsEntity result = searchServiceInterface.searchProductByIdService(productId);
		return result;
	}
	
	@GetMapping("/search-productList/{name}")
	public List<PrdouctsEntity> searchProductById(@PathVariable(value = "name") String productName) {
		List<PrdouctsEntity> result = searchServiceInterface.searchProductByNameService(productName);
		return result;
	}
	
	

}
