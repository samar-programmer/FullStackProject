package com.revature.projects.shopper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.projects.shopper.interfaces.OrderServiceInterface;
import com.revature.projects.shopper.model.OrderEntity;
import com.revature.projects.shopper.repository.OrderRepository;
@Service
public class OrderService implements OrderServiceInterface{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<OrderEntity> getOrderDetails() {
		return orderRepository.findAll();
	}

}
