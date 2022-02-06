package com.revature.projects.shopper.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.projects.shopper.dto.OrderDTO;
import com.revature.projects.shopper.interfaces.OrderServiceInterface;
import com.revature.projects.shopper.model.CartEntity;
import com.revature.projects.shopper.model.OrderEntity;
import com.revature.projects.shopper.repository.CartRepositoryInterface;
import com.revature.projects.shopper.repository.OrderRepository;
@Service

public class OrderService implements OrderServiceInterface{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CartRepositoryInterface CartRepositoryInterface;
	
	@Override
	public List<OrderEntity> getOrderDetails() {
		return orderRepository.findAll();
	}

	@Override
	public String setOrderService(OrderDTO orderdata) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		
		List<CartEntity> cartEntity = CartRepositoryInterface.findByEmailAndProductstatus(orderdata.getEmail(), "IN-CART");
		OrderEntity order=new OrderEntity();  
		order.setEmail(orderdata.getEmail());
		order.setOrderdDate(date);
		order.setStatus("NOT DELIVERED");
		order.setTotalOrderPrice(orderdata.getTotalPrice());
		//order.setCartId(cartEntity);
		
		orderRepository.save(order);//order saved
		
		List<OrderEntity> order1 = orderRepository.findByEamil(order.getEmail(),"NOT DELIVERED-e");
		
		int lengthOfOrder = order1.size()-1;
		
		Long orderdId = order1.get(lengthOfOrder).getOrderId() ;
		String orderSatus = "ORDERD";
		String email =orderdata.getEmail();
		
		System.out.println("sasi"+orderdId	);
		
		
		for(CartEntity cart : cartEntity) {
			System.out.println(cart);
			 //cart.setOrderIdEntity(order);
			 CartRepositoryInterface.updateOrderId(orderdId, orderSatus, email, "IN-CART");
		 }
		
		return "order Placed";
	}
	
	

}
