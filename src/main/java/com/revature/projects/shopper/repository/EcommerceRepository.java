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
//
//@Query("update com.revature.projects.shopper.model.EcommerceUser eu set eu.firstname=:firstname,eu.lastname=:lastname,eu.password=:password,eu.address=address,eu.mobilenumber=:mobilenumber where eu.email=:email")
//public EcommerceUser updateUserByEmailId(@Param("email")String email,@Param("password")String passsword,@Param("firstname")String firstname,@Param("lastname")String lastname,@Param("address")String address,@Param("mobilenumber")long mobilenumber);



@Modifying
@Query("update com.revature.projects.shopper.model.EcommerceUser eu set eu.password=:password,eu.firstname=:firstname,eu.lastname=:lastname,eu.mobilenumber=:mobilenumber where eu.email=:email")

//@Query(value="update ecommerce_user eu set eu.password=:password,eu.firstname=:firstname,eu.lastname=:lastname,eu.address=:address,eu.mobilenumber=:mobilenumber where eu.email=:email", nativeQuery=true)
public int updateUserByEmailId(@Param("email")String email, @Param("password")String password,@Param("firstname") String firstname,@Param("lastname") String lastname, @Param("mobilenumber") Long mobilenumber);


@Modifying
@Query("update com.revature.projects.shopper.model.EcommerceUser eu set eu.otp=:otp where email=:to")
public void updateUserByOtp(@Param("to")String to, @Param("otp")long otp);

@Query("from com.revature.projects.shopper.model.EcommerceUser eu where eu.otp=:otp")
public EcommerceUser fetchByOtp(@Param("otp")long tempOtp);

@Query("from com.revature.projects.shopper.model.EcommerceUser eu where eu.userid=:userid")
public EcommerceUser findById(@Param("userid") int userid);








}
