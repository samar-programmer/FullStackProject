package com.revature.projects.shopper.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.projects.shopper.model.PrdouctsEntity;

@Repository
public interface ProductRepositoryInterface extends JpaRepository<PrdouctsEntity, Long> {

}
