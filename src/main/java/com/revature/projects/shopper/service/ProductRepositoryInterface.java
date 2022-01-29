package com.revature.projects.shopper.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.projects.shopper.model.PrdouctsEntity;

public interface ProductRepositoryInterface extends JpaRepository<PrdouctsEntity, Long> {

}
