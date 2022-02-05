package com.revature.projects.shopper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.projects.shopper.interfaces.CartServiceInterface;
import com.revature.projects.shopper.model.CartEntity;
import com.revature.projects.shopper.model.PrdouctsEntity;
import com.revature.projects.shopper.utility.CartDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	CartServiceInterface cartServiceInterface;
	
	@GetMapping("/get-cart")
	public List<CartDTO> getAllProduct() {
		List<CartDTO> cartDto =  cartServiceInterface.getCartDetails();
		return cartDto;
	}
}
