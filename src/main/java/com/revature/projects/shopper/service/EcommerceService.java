package com.revature.projects.shopper.service;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.projects.shopper.interfaces.EcommerceServiceInterface;
import com.revature.projects.shopper.model.EcommerceUser;
import com.revature.projects.shopper.repository.EcommerceRepository;



@Service
@Transactional
public class EcommerceService implements EcommerceServiceInterface{

	@Autowired
	private EcommerceRepository repository;
	
	
	
	@Override
	public EcommerceUser createProfileService(EcommerceUser user) {
	
		repository.save(user);
		
		return user;
	}
	
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
		
		String from="Admin@gmail.com";
		
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
		
		return f;
	}

	@Override
	public EcommerceUser updateUserByEmailId( EcommerceUser ecommerceuser) {
		
		repository.saveAndFlush(ecommerceuser);
		
		return ecommerceuser;
	}
//
//	@Override
//	public int saveStatus(EcommerUser ecommerceuser1) {
//		
//		 repository.save(flag);
//		 
//		 return 1;
//	}

	@Override
	public int saveStatus(EcommerceUser ecommerceuser1) {
		
		repository.save(ecommerceuser1);
		
		return 1;
	}

	

	

	

}
