package com.revature.projects.shopper.interfaces;



import java.util.List;

import com.revature.projects.shopper.model.PrdouctsEntity;


public interface SearchServiceInterface {
	
	PrdouctsEntity searchProductByIdService(Long productId);

	List<PrdouctsEntity> searchProductByNameService(String productName);

	

}
