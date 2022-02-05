package com.revature.projects.shopper.model;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class EcommerceAddress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressid;
	
	private int doorno;
	private String name;
	private String streetname;
	private String city;
	private String state;
	private long pincode;
	private String landmark;
	private long phonenumber;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "userid")
	private EcommerceUser userdata;
	
	
	
}
