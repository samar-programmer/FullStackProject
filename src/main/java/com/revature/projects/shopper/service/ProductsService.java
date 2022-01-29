package com.revature.projects.shopper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.projects.shopper.interfaces.ProductServiceInterface;
import com.revature.projects.shopper.model.PrdouctsEntity;
@Service
@Transactional
public class ProductsService implements ProductServiceInterface {
	
	@Autowired
	private ProductRepositoryInterface productRepositoryInterface;

	@Override
	public int addProduct(PrdouctsEntity product) {
		int result = 0;
		productRepositoryInterface.save(product);
		result=1;
		return result;
	}

}
