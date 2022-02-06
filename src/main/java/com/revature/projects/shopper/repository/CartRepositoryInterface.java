package com.revature.projects.shopper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.projects.shopper.model.CartEntity;

public interface CartRepositoryInterface extends JpaRepository<CartEntity, Long> {
	
	@Query( value = "SELECT * FROM CART_TABLE u WHERE u.email =:email and u.productstatus =:productstatus",  nativeQuery = true)
	List<CartEntity> findByEmailAndProductstatus(@Param("email") String email, @Param("productstatus") String productstatus);
	
	
	
}
