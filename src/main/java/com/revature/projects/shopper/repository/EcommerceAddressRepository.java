package com.revature.projects.shopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.projects.shopper.model.EcommerceAddress;
import com.revature.projects.shopper.model.EcommerceUser;

@Repository
public interface EcommerceAddressRepository extends JpaRepository<EcommerceAddress,String>{
	
	

	
}
