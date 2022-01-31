package com.revature.projects.shopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.projects.shopper.model.ProductsEntity;

public interface ProductRepositoryInterface extends JpaRepository<ProductsEntity, Long> {

}
