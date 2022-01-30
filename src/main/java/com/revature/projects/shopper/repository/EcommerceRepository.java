package com.revature.projects.shopper.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.projects.shopper.model.EcommerceUser;

@Repository
public interface EcommerceRepository extends  JpaRepository<EcommerceUser, Integer>{


@Query("from com.revature.projects.shopper.model.EcommerceUser eu where eu.email=:email")
public EcommerceUser findByEmailId(@Param("email")String email);
	
	
@Query("from com.revature.projects.shopper.model.EcommerceUser eu where eu.email=:email and eu.password=:password")
public EcommerceUser fetchUserByEmailIdAndPassword(@Param("email")String email, @Param("password")String password);




}
