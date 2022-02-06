package com.revature.projects.shopper.model;

import javax.persistence.*;
import java.util.*;



import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class EcommerceUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	
//	 @OneToMany(mappedBy="userid")//,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	private List<EcommerceAddress> ecommerceaddress;
	
	@Column(unique=true)
	private String email;
	
	private String firstname;
	private String lastname;
	private String password;
	private String status;
	
	private long otp;
	private long mobilenumber;

	
	
}
