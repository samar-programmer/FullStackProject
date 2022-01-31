package com.revature.projects.shopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.projects.shopper.model.ProductCategory;


@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>  {

}
