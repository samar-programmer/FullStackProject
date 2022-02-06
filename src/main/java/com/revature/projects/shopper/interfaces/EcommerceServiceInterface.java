package com.revature.projects.shopper.interfaces;

import com.revature.projects.shopper.model.EcommerceAddress;
import com.revature.projects.shopper.model.EcommerceUser;

public interface EcommerceServiceInterface {

	

	public EcommerceUser fetchUserByEmailId(String tempEmailId);


	public int signUpProfileService(EcommerceUser user);

	public EcommerceUser fetchUserByEmailIdAndPassword(String tempEmailId, String tempPass);

	public boolean sendEmail(String subject, String message, String to);




	public int saveStatus(EcommerceUser ecommerceuser1);

	public EcommerceUser updateUserByEmailId( EcommerceUser ecommerceuser);

	public int updateUserByEmailId(String email, String password, String firstname, String lastname,
			Long mobilenumber);


	public int updateUserByOtp(String to, long otp);


	public EcommerceUser fetchByOtp(long tempOtp);


	public boolean sendPassword(String subject, String tempPassword, String tempEmail);


	public int saveAddressService(EcommerceAddress ecommerceaddress);



	

}
