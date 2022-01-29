package com.revature.projects.shopper.model;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "products_table")
public class PrdouctsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
	private String productName;
    private String category;
    @Column(length = 100000)
    private String imgsrc;
    private String addeddate;
    private String productPrice;
    private String productDiscountPrice;
}