package com.revature.projects.shopper.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "orders_table")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	private String email;
	private String totalOrderPrice;
	private String status;
	private String orderdDate;
	
//	@OneToMany(mappedBy = "orderIdEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	private List<CartEntity> cartId;
	
	
}
