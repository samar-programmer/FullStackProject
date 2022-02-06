package com.revature.projects.shopper.interfaces;

import java.util.List;

import com.revature.projects.shopper.model.CartEntity;
import com.revature.projects.shopper.utility.CartDTO;

public interface CartServiceInterface {

	List<CartDTO> getCartDetails(String email);

	String addProductCartService(CartEntity cartProduct);

}
