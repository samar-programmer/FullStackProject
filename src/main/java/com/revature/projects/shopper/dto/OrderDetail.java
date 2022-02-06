package com.revature.projects.shopper.dto;

import lombok.Data;

@Data
public class OrderDetail {
	private String orderId;
	private String orederStatus;
	private int orederAmount;
}
