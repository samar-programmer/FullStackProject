package com.revature.projects.shopper.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class ProductCategory {
	//product_category
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	private String categoryName;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="category")
	@JsonBackReference
	private Set<ProductsEntity> products;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<ProductsEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductsEntity> products) {
		this.products = products;
	}
}
 