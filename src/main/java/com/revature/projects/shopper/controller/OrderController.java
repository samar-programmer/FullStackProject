package com.revature.projects.shopper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.projects.shopper.dto.OrderDTO;
import com.revature.projects.shopper.interfaces.OrderServiceInterface;
import com.revature.projects.shopper.model.OrderEntity;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderServiceInterface orderServiceInterface;
	
	@GetMapping("/get-allOrder")
	public List<OrderEntity> getAllProduct() {
		List<OrderEntity> orders =  orderServiceInterface.getOrderDetails();
		return orders;
	}
	
	
	@PostMapping("/setOrder")
	public String setOrder(@RequestBody OrderDTO orderdata) {
		String email="aa@gmail.com";
		String result=orderServiceInterface.setOrderService(orderdata);
		return result;
	}
	
	
}
