package com.revature.projects.shopper.utility;

import javax.persistence.Column;

import com.revature.projects.shopper.model.CartEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CartDTO {
	private Long cartId;
	private String email;
	private long productId;
	private long productQuantity;
	private long totalPrize;
	private String productstatus;
	private long orderdId;
	private String productName;
    private String category;
    private String imgsrc;
    private String addeddate;
    private String productPrice;
    private String productDiscountPrice;
    private long quantityprice ;
}
