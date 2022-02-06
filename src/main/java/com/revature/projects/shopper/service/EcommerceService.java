package com.revature.projects.shopper.service;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.projects.shopper.interfaces.EcommerceServiceInterface;
import com.revature.projects.shopper.model.EcommerceAddress;
import com.revature.projects.shopper.model.EcommerceUser;
import com.revature.projects.shopper.repository.EcommerceAddressRepository;
import com.revature.projects.shopper.repository.EcommerceRepository;



@Service
@Transactional
public class EcommerceService implements EcommerceServiceInterface{

	@Autowired
	private EcommerceRepository repository;
	@Autowired
	private EcommerceAddressRepository addressrepository;
	
	
	
//	@Override
//	public EcommerceUser createProfileService(EcommerceUser user) {
//	
//		repository.save(user);
//		
//		return user;
//	}
	
	public EcommerceUser fetchUserByEmailId(String email)
	{
		return repository.findByEmailId(email);
	}

	@Override
	public int signUpProfileService(EcommerceUser user) {
		
		repository.save(user);
		
		return 1;
	}

	@Override
	public EcommerceUser fetchUserByEmailIdAndPassword(String email, String password) {
	
		return repository.fetchUserByEmailIdAndPassword(email,password);
	}

	@Override
	public boolean sendEmail(String subject, String message, String to) {
		
		boolean f=false;
		
		String from="manojselvi529@gmail.com";
		
		String host="smtp.gmail.com";
		
		Properties properties=System.getProperties();
		
		
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session=Session.getInstance(properties, new Authenticator()
				{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("manojselvi529@gmail.com","pasauzpmpmfxoqrj");
			}
				});
		
		session.setDebug(true);
		
		MimeMessage mimemessage=new MimeMessage(session);
		
		try
		{
			mimemessage.setFrom(from);
			mimemessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimemessage.setSubject(subject);
			mimemessage.setText(message);
			Transport.send(mimemessage);
			
			System.out.println("Sent Success.............");
			
			f=true;
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//repository.save(message,to);
		return f;
	}

	
	
	@Override
	public boolean sendPassword(String subject, String tempPassword, String tempEmail) {
		
		
		boolean f=false;
		
		String from="manojselvi529@gmail.com";
		
		String host="smtp.gmail.com";
		
		Properties properties=System.getProperties();
		
		
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session=Session.getInstance(properties, new Authenticator()
				{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("manojselvi529@gmail.com","pasauzpmpmfxoqrj");
			}
				});
		
		session.setDebug(true);
		
		MimeMessage mimemessage=new MimeMessage(session);
		
		try
		{
			mimemessage.setFrom(from);
			mimemessage.addRecipient(Message.RecipientType.TO, new InternetAddress(tempEmail));
			mimemessage.setSubject(subject);
			mimemessage.setText("Your PassWord is  "+tempPassword);
			Transport.send(mimemessage);
			
			System.out.println("Sent Success.............");
			
			f=true;
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return f;
	}

	


	@Override
	public int saveStatus(EcommerceUser ecommerceuser1) {
		
		repository.save(ecommerceuser1);
		
		return 1;
	}

	@Override
	public EcommerceUser updateUserByEmailId(EcommerceUser ecommerceuser) {
		
		repository.saveAndFlush(ecommerceuser);
		
		return ecommerceuser;
	}

	@Override
	public int updateUserByEmailId(String email, String password, String firstname, String lastname,
			Long mobilenumber) {
		
		 repository.updateUserByEmailId(email,password,firstname,lastname,mobilenumber);
		 return 1;
	}

	@Override
	public int updateUserByOtp(String to, long otp) {
		
		repository.updateUserByOtp(to,otp);
		
		return 1;
	}

	@Override
	public EcommerceUser fetchByOtp(long tempOtp) {
		
		return repository.fetchByOtp(tempOtp);
	}

	@Override
	public int saveAddressService(EcommerceAddress ecommerceaddress) {
		
		try
		{
		
		EcommerceUser eu=repository.findByEmailId(ecommerceaddress.getUserdata().getEmail());
		ecommerceaddress.setUserdata(eu);
		addressrepository.save(ecommerceaddress);
		return 1;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		 
	
	}

	

}
