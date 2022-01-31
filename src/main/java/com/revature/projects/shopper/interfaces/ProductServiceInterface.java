package com.revature.projects.shopper.interfaces;

import java.util.List;

import com.revature.projects.shopper.model.PrdouctsEntity;

public interface ProductServiceInterface {

	int addProduct(PrdouctsEntity product);

	List<PrdouctsEntity> getProducts();

	int DeleteProduct(Long productId);

}
