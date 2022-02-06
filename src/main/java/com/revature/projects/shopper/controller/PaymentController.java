package com.revature.projects.shopper.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.razorpay.*;
import com.revature.projects.shopper.dto.OrderDetail;
import com.revature.projects.shopper.dto.PaymentInfoDTO;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/payment")
public class PaymentController {
	
	@PostMapping("/makePayment")
	public OrderDetail makePaymentController(@RequestBody PaymentInfoDTO paymentInfo){
		int amount=Integer.parseInt(paymentInfo.get_amount());
		OrderDetail orderdetail=new OrderDetail();
		Order order = null;
		try {
			RazorpayClient client=	new RazorpayClient("rzp_test_eKMQiTe1MYTomX", "wmTBFD0Z0ujoc8cC2iK8c6Am");
			
			JSONObject ob=new JSONObject();
			ob.put("amount", amount*100);
			ob.put("currency", "INR");
			ob.put("receipt", "sp_739");
			
			
			order=client.Orders.create(ob);
			System.out.println(order);
			
			
			orderdetail.setOrderId(order.get("id"));
			orderdetail.setOrederStatus(order.get("status"));
			orderdetail.setOrederAmount(order.get("amount"));
			
			
		} catch (RazorpayException e) {
			e.printStackTrace();
		}
	
		
		return orderdetail;
	}
	
}
