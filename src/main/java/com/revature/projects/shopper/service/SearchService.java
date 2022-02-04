package com.revature.projects.shopper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.projects.shopper.interfaces.ProductServiceInterface;
import com.revature.projects.shopper.interfaces.SearchServiceInterface;
import com.revature.projects.shopper.model.PrdouctsEntity;
import com.revature.projects.shopper.repository.SearchProductRepository;

@Service
@Transactional
public class SearchService implements SearchServiceInterface {
	
	@Autowired
	private ProductRepositoryInterface productRepositoryInterface;
	
	@Autowired
	private SearchProductRepository searchProductRepository;
	
	@Override
	public PrdouctsEntity searchProductByIdService(Long productId) {
		// TODO Auto-generated method stub
		 Optional<PrdouctsEntity> product=productRepositoryInterface.findById(productId);
		 return product.get();
	}

	@Override
	public List<PrdouctsEntity> searchProductByNameService(String productName) {
		List<PrdouctsEntity> productList=searchProductRepository.findByProductNameContainingIgnoreCase(productName);
		return productList;
	}

}
