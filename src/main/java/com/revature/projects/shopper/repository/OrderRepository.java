package com.revature.projects.shopper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.projects.shopper.model.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
	@Query(value = "SELECT ORDER_ID FROM orders_table u WHERE u.email =:email and STATUS=:status ", nativeQuery = true)
	List<Integer> findByEamil(@Param("email") String email, String status);
	
	@Query(value = "SELECT * FROM orders_table u WHERE u.email =:email", nativeQuery = true)
	List<OrderEntity> findByEamilForOrder(String email);
	 

//	@Query( value = "select * from orders_table where ORDER_ID = ( select max(ORDER_ID) from orders_table )",  nativeQuery = true)
//	OrderEntity findByEamil(@Param("email")  String email, String status);

}
