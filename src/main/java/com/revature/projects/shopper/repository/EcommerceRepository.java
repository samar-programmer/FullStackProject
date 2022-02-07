package com.revature.projects.shopper.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.projects.shopper.model.EcommerceAddress;
import com.revature.projects.shopper.model.EcommerceUser;

@Repository
public interface EcommerceRepository extends  JpaRepository<EcommerceUser,String>{


@Query("from com.revature.projects.shopper.model.EcommerceUser eu where eu.email=:email")
public EcommerceUser findByEmailId(@Param("email")String email);
	
	
@Query("from com.revature.projects.shopper.model.EcommerceUser eu where eu.email=:email and eu.password=:password")
public EcommerceUser fetchUserByEmailIdAndPassword(@Param("email")String email, @Param("password")String password);



@Modifying
@Query("update com.revature.projects.shopper.model.EcommerceUser eu set eu.password=:password,eu.firstname=:firstname,eu.lastname=:lastname,eu.mobilenumber=:mobilenumber where eu.email=:email")
public int updateUserByEmailId(@Param("email")String email, @Param("password")String password,@Param("firstname") String firstname,@Param("lastname") String lastname, @Param("mobilenumber") Long mobilenumber);


@Modifying
@Query("update com.revature.projects.shopper.model.EcommerceUser eu set eu.otp=:otp where email=:to")
public void updateUserByOtp(@Param("to")String to, @Param("otp")long otp);

@Query("from com.revature.projects.shopper.model.EcommerceUser eu where eu.otp=:otp")
public EcommerceUser fetchByOtp(@Param("otp")long tempOtp);

@Query("from com.revature.projects.shopper.model.EcommerceUser eu where eu.userid=:userid")
public EcommerceUser findById(@Param("userid") int userid);








}
