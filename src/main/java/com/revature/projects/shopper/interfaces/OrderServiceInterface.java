package com.revature.projects.shopper.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.projects.shopper.dto.OrderDTO;
import com.revature.projects.shopper.model.OrderEntity;
@Repository
public interface OrderServiceInterface {

	List<OrderEntity> getOrderDetails();

	String setOrderService(OrderDTO orderdata);

	List<OrderEntity> getOrderDetail(String email);

}
