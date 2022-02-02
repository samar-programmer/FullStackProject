package com.revature.projects.shopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.projects.shopper.model.PrdouctsEntity;

public interface ProductRepositoryInterface extends JpaRepository<PrdouctsEntity, Long> {

	@Query( value = "SELECT * FROM PRODUCTS_TABLE u WHERE u.product_id=:productId",  nativeQuery = true)
	PrdouctsEntity findByIdForImgUrl(@Param("productId") long productId);

}
