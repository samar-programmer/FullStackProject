package com.revature.projects.shopper.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class ProductsEntity {
	//products_entity
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonManagedReference
	private ProductCategory category;

	private String productName;
    @Column(length = 1000)
    private String imgsrc;
    @UpdateTimestamp
    private Date addeddate;
    private String productPrice;
    private String productDiscountPrice;
    private String activeStat;
    private String unitsInStock;
    
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public Date getAddeddate() {
		return addeddate;
	}
	public void setAddeddate(Date addeddate) {
		this.addeddate = addeddate;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDiscountPrice() {
		return productDiscountPrice;
	}
	public void setProductDiscountPrice(String productDiscountPrice) {
		this.productDiscountPrice = productDiscountPrice;
	}
	public String getActiveStat() {
		return activeStat;
	}
	public void setActiveStat(String activeStat) {
		this.activeStat = activeStat;
	}
	public String getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(String unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	
    
    
}