package com.revature.projects.shopper.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.projects.shopper.interfaces.EcommerceServiceInterface;
import com.revature.projects.shopper.model.EcommerceUser;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/product")

public class UserController {
	
	@Autowired
	private EcommerceServiceInterface service;
	
	EcommerceUser ecommerceuser=new EcommerceUser();
	EcommerceUser ecommerceuser1=new EcommerceUser();
	
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
		int i=0;
		String tempEmailId=ecommerceuser.getEmail();
		String tempPass=ecommerceuser.getPassword();
		System.out.println(ecommerceuser.getPassword());
	
		
		if(tempEmailId !=null && !"".equals(tempEmailId))
		{
			ecommerceuser=service.fetchUserByEmailId(tempEmailId);
		//	System.out.println(ecommerceuser.getPassword());
			if(ecommerceuser==null)
			{
				
				ecommerceuser1.setEmail(tempEmailId);
				ecommerceuser1.setPassword(tempPass);
				System.out.println(ecommerceuser1.getPassword());
				System.out.println("Hello there");
				 i=service.signUpProfileService(ecommerceuser1);
				
			}
			else
			{
				throw new Exception("User with "+tempEmailId+" already Exists");
			}
			}
		
		
		
		
		
		if(i>0)
		{
			//System.out.println(ecommerceuser.getPassword());
			
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
			System.out.println("hello admin");
			if(tempEmailId.equals("Admin@gmail.com"))
			{
				System.out.println("hello admin");
			
			ecommerceuser=service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
			ecommerceuser1.setStatus("ADMIN");
			int i=service.saveStatus(ecommerceuser1);
			}
			else
			{
				System.out.println("hello user");
				
				ecommerceuser=service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
				ecommerceuser1.setStatus("USER");
				int i=service.saveStatus(ecommerceuser1);
			}
			
		}
		
		if(ecommerceuser1!=null)
		{
			System.out.println(tempEmailId);
			if(tempEmailId.equals("Admin@gmail.com"))
			{
				return "Admin Logged IN";
			}
			else
			{
				return "User Logged IN";
			}
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
	
	
	@PutMapping("/editProfile/{email}")
	public String editProfile(@PathVariable("email")String email,@RequestBody EcommerceUser ecommerceuser)throws Exception
	{
//		String tempEmailId=ecommerceuser.getEmail();
//		System.out.println(tempEmailId);
//		if(tempEmailId !=null)
//		{
			ecommerceuser=service.updateUserByEmailId(ecommerceuser);
			
		//}
		
		if(ecommerceuser!=null)
		{
			return "Database Updated";
		}
		else
		{
		throw new Exception("Could not Update Your Database");
		}
	}
	

}
