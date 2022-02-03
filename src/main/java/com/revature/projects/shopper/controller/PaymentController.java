package com.revature.projects.shopper.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.projects.shopper.dto.PaymentInfoDTO;
import com.revature.projects.shopper.model.PrdouctsEntity;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/payment")
public class PaymentController {
	
	@PostMapping("/makePayment")
	public String makePaymentController(@RequestBody PaymentInfoDTO paymentInfo){
		System.out.println(paymentInfo.getAmount());
		return "";
	}
	
}
