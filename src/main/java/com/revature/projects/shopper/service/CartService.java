package com.revature.projects.shopper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.projects.shopper.interfaces.CartServiceInterface;
import com.revature.projects.shopper.model.CartEntity;
import com.revature.projects.shopper.model.PrdouctsEntity;
import com.revature.projects.shopper.repository.CartRepositoryInterface;
import com.revature.projects.shopper.repository.ProductRepositoryInterface;
import com.revature.projects.shopper.utility.CartDTO;
@Service
public class CartService implements CartServiceInterface{
	
	@Autowired
	CartRepositoryInterface CartRepositoryInterface;
	
	@Autowired
	ProductRepositoryInterface productRepositoryInterface;


	@Override
	public List<CartDTO> getCartDetails(String email) {
		// TODO Auto-generated method stub
		List<CartDTO> cartDtos = new ArrayList() ;
		 List<CartEntity> cartEntity = CartRepositoryInterface.findByEmailAndProductstatus(email, "IN-CART");
		  
		 for(CartEntity cart : cartEntity) {
			 PrdouctsEntity prdouctsEntity = productRepositoryInterface.findByIdForImgUrl(cart.getProductId());
			CartDTO cartdto = new CartDTO();
			 BeanUtils.copyProperties(cart, cartdto);
			 BeanUtils.copyProperties(prdouctsEntity, cartdto);
			 cartdto.setQuantityprice(cart.getProductQuantity() * Long.parseLong(prdouctsEntity.getProductDiscountPrice()) );
			 cartDtos.add(cartdto);
			 
		 }
		 
		 return cartDtos;
	}


	@Override
	public String addProductCartService(CartEntity cartProduct) {
		try {
			CartRepositoryInterface.save(cartProduct);
			return "product added";
		}catch(Exception e){
			e.printStackTrace();
			return "product add fail";
		}
	
		
	}

}
