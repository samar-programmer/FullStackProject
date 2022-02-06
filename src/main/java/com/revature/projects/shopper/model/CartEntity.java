package com.revature.projects.shopper.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import com.revature.projects.shopper.model.PrdouctsEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "cart_table")
public class CartEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartId;
	
	private String email;
	private long productId;
	private long productQuantity;
	private long totalPrize;
	private String productstatus;
	
	
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
				name="order_Id",
				referencedColumnName = "orderId"
			)
	private OrderEntity orderIdEntity;
	
	
	
	
	 
	 
}
