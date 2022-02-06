package com.revature.projects.shopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.projects.shopper.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
