package com.revature.projects.shopper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.projects.shopper.interfaces.ProductServiceInterface;
import com.revature.projects.shopper.model.ProductsEntity;
import com.revature.projects.shopper.repository.ProductRepositoryInterface;


@Service
@Transactional
public class ProductsService implements ProductServiceInterface {
	
	@Autowired
	private ProductRepositoryInterface productRepositoryInterface;

	@Override
	public List<ProductsEntity> getAllProductsService() {
		List<ProductsEntity> productsEntityList =productRepositoryInterface.findAll();
		return productsEntityList;
	}

	@Override
	public Optional<ProductsEntity> getProductByIdService(ProductsEntity dtoProduct) {
		Optional<ProductsEntity> product=null;
		try{
			product=productRepositoryInterface.findById(dtoProduct.getProductId());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
		
	}

	@Override
	public int addProductService(ProductsEntity product) {
		int result = 0;
		try {
			productRepositoryInterface.save(product);
			result=1;
			return result;
		}catch(Exception e) {
			return result;
		}
		
		
	}

	@Override
	public int deleteProductByIdService(ProductsEntity dtoProduct) {
		int result = 0;
		try {
			productRepositoryInterface.deleteById(dtoProduct.getProductId());
			result=1;
			return result;
		}catch(Exception e) {
			return result;
		}
	}

	@Override
	public int updateProductByIdService(ProductsEntity product) {
		int result = 0;
		try {
			productRepositoryInterface.save(product);
			result=1;
			return result;
		}catch(Exception e) {
			return result;
		}
	}
	
	

}
