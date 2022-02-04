package com.revature.projects.shopper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.projects.shopper.model.PrdouctsEntity;


@Repository
public interface SearchProductRepository extends JpaRepository<PrdouctsEntity, Long> {
	
	List<PrdouctsEntity> findByProductNameContainingIgnoreCase(String productName);
}
