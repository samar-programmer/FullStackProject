package com.revature.projects.shopper.interfaces;

import java.util.List;
import java.util.Optional;

import com.revature.projects.shopper.model.ProductsEntity;

public interface ProductServiceInterface {

	List<ProductsEntity> getAllProductsService();

	Optional<ProductsEntity>getProductByIdService(ProductsEntity dtoProduct);
	int addProductService(ProductsEntity product);

	int deleteProductByIdService(ProductsEntity dtoProduct);

	int updateProductByIdService(ProductsEntity product);
}
