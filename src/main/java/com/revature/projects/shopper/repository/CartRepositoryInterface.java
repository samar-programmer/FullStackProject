package com.revature.projects.shopper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.projects.shopper.model.CartEntity;

public interface CartRepositoryInterface extends JpaRepository<CartEntity, Long> {
	
	@Query( value = "SELECT * FROM CART_TABLE u WHERE u.email =:email and u.productstatus =:productstatus",  nativeQuery = true)
	List<CartEntity> findByEmailAndProductstatus(@Param("email") String email, @Param("productstatus") String productstatus);

	@Query( value = "UPDATE CART_TABLE  set PRODUCTSTATUS =:orderSatus, ORDER_ID =:orderId WHERE EMAIL =:email and PRODUCTSTATUS=:status",  nativeQuery = true)
	void updateOrderId(@Param("orderId") Long orderId, @Param("orderSatus") String orderSatus, @Param("email") String email, String status);
	
	
	
	
	
}
