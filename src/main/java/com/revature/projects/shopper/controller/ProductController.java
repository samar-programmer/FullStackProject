package com.revature.projects.shopper.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.projects.shopper.interfaces.ProductServiceInterface;
import com.revature.projects.shopper.model.ProductCategory;
import com.revature.projects.shopper.model.ProductsEntity;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductServiceInterface productServiceInterface;
	
	@GetMapping("/Products")
	public ResponseEntity<List<ProductsEntity>> getAllProducts() {
//		ProductsEntity product=new ProductsEntity();
//		product.setActiveStat("active");
//		product.setImgsrc("heello");
//		product.setProductDiscountPrice(25);
//		product.setProductPrice(50);
//		product.setUnitsInStock(3);
//		
//		ProductsEntity product2=new ProductsEntity();
//		product.setActiveStat("active");
//		product.setImgsrc("heello");
//		product.setProductDiscountPrice(55);
//		product.setProductPrice(55);
//		product.setUnitsInStock(3);
//		
//		ProductCategory productCategory1=new ProductCategory();
//		productCategory1.setCategoryName("veg");
//		
//		
//		product.setCategory(productCategory1);
//		product2.setCategory(productCategory1);
//		
//		Set<ProductsEntity> productSet=new HashSet<ProductsEntity>();
//		productSet.add(product);
//		productSet.add(product2);
//		
//		productCategory1.setProducts(productSet);
		
		
		List<ProductsEntity> productsList=productServiceInterface.getAllProductsService();
		if(productsList.size()<=0) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(productsList));
	}
	
	@GetMapping("/Products/{id}")
	public ResponseEntity<ProductsEntity> getProductById(@PathVariable("id") Long productId) {
		ProductsEntity DtoProduct=new ProductsEntity();
		DtoProduct.setProductId(productId);
		Optional<ProductsEntity>productsList=productServiceInterface.getProductByIdService(DtoProduct);
		 if (productsList.isPresent()) {
			 return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(productsList);
		
	}
	
	@RequestMapping(value="/Products",method = RequestMethod.POST,consumes = "application/json")
	public ResponseEntity<Void> addProduct(@RequestBody ProductsEntity product) {
		System.out.println("Inside post");
		try {
			int result = productServiceInterface.addProductService(product);
			System.out.println(result);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/Products/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable("id") Long productId) {
		try {
			ProductsEntity DtoProduct=new ProductsEntity();
			DtoProduct.setProductId(productId);
			int result = productServiceInterface.deleteProductByIdService(DtoProduct);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {	
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
	}
	
	@PutMapping("/Products/{id}")
	public ResponseEntity<ProductsEntity> updateProductById(@RequestBody ProductsEntity product ,@PathVariable("id") Long productId) {
		try {
			product.setProductId(productId);
			int result = productServiceInterface.updateProductByIdService(product);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch(Exception e) {	
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
		
	}
}
