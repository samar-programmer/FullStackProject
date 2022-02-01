package com.revature.projects.shopper.interfaces;

import com.revature.projects.shopper.model.EcommerceUser;

public interface EcommerceServiceInterface {

	public EcommerceUser createProfileService(EcommerceUser user);

	public EcommerceUser fetchUserByEmailId(String tempEmailId);


	public int signUpProfileService(EcommerceUser user);

	public EcommerceUser fetchUserByEmailIdAndPassword(String tempEmailId, String tempPass);

	public boolean sendEmail(String subject, String message, String to);

	//public EcommerceUser updateUserByEmailId(String tempEmailId);

	public EcommerceUser updateUserByEmailId( EcommerceUser ecommerceuser);

	public int saveStatus(EcommerceUser ecommerceuser1);

}
