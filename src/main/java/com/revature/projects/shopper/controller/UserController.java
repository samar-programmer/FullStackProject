package com.revature.projects.shopper.controller;

import java.util.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.ServletRequestAttributes;
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
import org.springframework.web.context.request.RequestContextHolder;

import com.revature.projects.shopper.interfaces.EcommerceServiceInterface;
import com.revature.projects.shopper.model.EcommerceAddress;
import com.revature.projects.shopper.model.EcommerceUser;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/customer")

public class UserController {
	
	@Autowired
	private EcommerceServiceInterface service;
	
	EcommerceUser ecommerceuser=new EcommerceUser();
	EcommerceUser ecommerceuser1=new EcommerceUser();
	EcommerceAddress ecommerceaddress=new EcommerceAddress();
	
	Random random=new Random(1000);
	
	
	
	HttpServletRequest request; 
	HttpSession session;

	
	@PostMapping("/signUp")
	public String signUpProfile(@RequestBody EcommerceUser ecommerceuser) throws Exception
	{
		int i=0;
		String tempEmailId=ecommerceuser.getEmail();
		String tempPass=ecommerceuser.getPassword();
		
	
		
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
		
			if(tempEmailId.equals("Admin@gmail.com"))
			{
				//request.getSession().setAttribute("user", tempEmailId);
				System.out.println("hello admin");
			
			ecommerceuser=service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
			if(ecommerceuser!=null)
			{
			
			ecommerceuser1.setStatus("ADMIN");
			int i=service.saveStatus(ecommerceuser1);
			 }
			}
			else
			{
				System.out.println("hello user");
				System.out.println(tempEmailId);
				//session=request.getSession(true);
				//session.setAttribute("user",tempEmailId);
				//request.getSession().getAttribute("tempEmailId");
				
				ecommerceuser=service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
				if(ecommerceuser!=null)
				{
			
				ecommerceuser1.setStatus("USER");
				int i=service.saveStatus(ecommerceuser1);
				}
			}
			
		}
		
		if((ecommerceuser!=null) && (ecommerceuser1!=null))
		{
			System.out.println(tempEmailId);
			if(tempEmailId.equals("Admin@gmail.com"))
			{
				return ecommerceuser.getEmail();
			}
			else
			{
				return ecommerceuser.getEmail();
			}
		}
		else
		{
		 throw new Exception("login failed!!!! SIGN UP FIRST");
		}
	}
	
	
	@PostMapping("/send-otp")
	public String sendOTP(@RequestBody EcommerceUser ecommerceuser)
	{
		long  otp=random.nextInt(999999);
		
		String subject="OTP from SHOPPER";
		String message="OTP to Change Your Password is = "+otp;
		System.out.println("Hello otp");
		System.out.println(ecommerceuser.getEmail());	
		String to=ecommerceuser.getEmail();
	
		System.out.println(message);
		System.out.println(to);
		
		boolean flag=this.service.sendEmail(subject,message,to);
		
		System.out.println(to);
		int i=service.updateUserByOtp(to,otp);
		
		if(flag)
		{
			//session.setAttribute("otp", otp);
			return "verify otp";
		}
		else
		{
			//session.setAttribute("message","Check Your Email Id !!!" );
		return "Wrong Credentials";
		}
	}
	
	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestBody EcommerceUser ecommerceuser)
	{
		long tempOtp=ecommerceuser.getOtp();
		
		if(tempOtp!=0)
		{
		ecommerceuser=service.fetchByOtp(tempOtp);

		
		}
		String tempEmail=ecommerceuser.getEmail();
		String tempPassword=ecommerceuser.getPassword();
		String subject="PASSWORD From SHOPPER";
		
		boolean flag=this.service.sendPassword(subject,tempPassword,tempEmail);
		
		
		if(ecommerceuser!=null)
		{
		return "OTP	 Verified !!! See Your Email For Password";
		}
		else
		{
			return "Incorrect OTP";
		}
	
	}
	
	
	
	@PutMapping("/editProfile/{email}")
	public String editProfile(@PathVariable("email")String email,@RequestBody EcommerceUser ecommerceuser)throws Exception
	{

		String firstname=ecommerceuser.getFirstname();
		String lastname=ecommerceuser.getLastname();
		String password=ecommerceuser.getPassword();

		Long mobilenumber=ecommerceuser.getMobilenumber();
		
		
		
			int i=service.updateUserByEmailId(email,password,firstname,lastname,mobilenumber);

		
		if(i!=0)
		{
			return "Database Updated";
		}
		else
		{
		throw new Exception("Could not Update Your Database");
		}
	}
	
	
	
	@PostMapping("/address")
	public String saveAddress(@RequestBody EcommerceAddress ecommerceaddress)
	{
		System.out.println(ecommerceaddress.getDoorno());
		
//		EcommerceUser eu=new EcommerceUser();
//		eu.setUserid(userid);
//		ecommerceaddress.setUserdata(eu);
//		System.out.println(userid);
		int i=service.saveAddressService(ecommerceaddress);
		
		if(i!=0)
		{
		return "Address Saved";
		}
	
		else
	
		{
			return "No Address Available";
		}
	
	}
	
	
	
	
		@GetMapping("/logOut")
		public String logout(){
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			session.invalidate(); 
			return "LogOut Successfull" ;
		}


}
