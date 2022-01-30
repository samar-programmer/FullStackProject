package com.revature.projects.shopper.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.projects.shopper.interfaces.EcommerceServiceInterface;
import com.revature.projects.shopper.model.EcommerceUser;




@RestController
//@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	private EcommerceServiceInterface service;
	
	EcommerceUser ecommerceuser;
	
	Random random=new Random(1000);
	
	HttpSession session;
	
	@PostMapping("/register")
	public String createProfile(@RequestBody EcommerceUser ecommerceuser)
	{
		
		
		
		ecommerceuser=service.createProfileService(ecommerceuser);
		
		if(ecommerceuser!=null)
		{
	
		return "Profile Created";
		}
		
		else
		{
			return "Could not Create Profile";
		}
	}
	
	
	
	@PostMapping("/signUp")
	public String signUpProfile(@RequestBody EcommerceUser ecommerceuser) throws Exception
	{
		
		String tempEmailId=ecommerceuser.getEmail();
		System.out.println(ecommerceuser.getPassword());
		if(tempEmailId !=null && !"".equals(tempEmailId))
		{
			ecommerceuser=service.fetchUserByEmailId(tempEmailId);
			if(ecommerceuser!=null)
			{
				throw new Exception("User with "+tempEmailId+"  already Exists");
			}
		}
		
		System.out.println(ecommerceuser.getPassword());
		
		int i=service.signUpProfileService(ecommerceuser);
		
		if(i>0)
		{
			System.out.println(ecommerceuser.getPassword());
			
		return "User Signed UP";
		}
		
		else
		{
			return "Could not able to Sign Up";
		}
	}
	
	
	@PostMapping("/signIn")
	
	public String signInProfile(@RequestBody EcommerceUser ecommerceuser) throws Exception
	{
		String tempEmailId=ecommerceuser.getEmail();
		String tempPass=ecommerceuser.getPassword();
		
		
		
		if(tempEmailId !=null && tempPass!=null)
		{
			ecommerceuser=service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
			
		}
		
		if(ecommerceuser!=null)
		{
		return "Login Successful";
		}
		else
		{
		 throw new Exception("login failed");
		}
	}
	
	
	@PostMapping("/send-otp")
	public String sendOTP(@RequestBody EcommerceUser ecommerceuser)
	{
		int  otp=random.nextInt(999999);
		
		String subject="OTP from SHOPFLY";
		String message="<h1> OTP = "+otp+" </h1>";
		System.out.println("Hello otp");
		System.out.println(ecommerceuser.getEmail());	
		String to=ecommerceuser.getEmail();
	
		boolean flag=this.service.sendEmail(subject,message,to);
		
		if(flag)
		{
			//session.setAttribute("otp", otp);
			return "verify otp";
		}
		else
		{
			//session.setAttribute("message","Check Your Email Id !!!" );
		return "Forgot Email";
		}
	}
	

}
