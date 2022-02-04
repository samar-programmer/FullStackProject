package com.revature.projects.shopper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.projects.shopper.interfaces.ProductServiceInterface;
import com.revature.projects.shopper.model.PrdouctsEntity;
import com.revature.projects.shopper.repository.ProductRepositoryInterface;

@Service
@Transactional
public class ProductsService implements ProductServiceInterface {
	
	@Autowired
	private ProductRepositoryInterface productRepositoryInterface;

	@Override
	public int addProduct(PrdouctsEntity product) {
		int result = 0;
		productRepositoryInterface.saveAndFlush(product);
		result=1;
		return result;
	}

	@Override
	public List<PrdouctsEntity> getProducts() {
		
		return productRepositoryInterface.findAll();
	}

	@Override
	public int DeleteProduct(Long productId) {
		int result = 0;
		Optional<PrdouctsEntity> product = productRepositoryInterface.findById(productId);
		if(product.isPresent()) {
			productRepositoryInterface.delete(product.get());
		}
		result=1;
		return result;
	}

}
