package com.revature.projects.shopper.model;

import javax.persistence.*;



import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class EcommerceUser {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	
	@Column(unique=true)
	private String email;
	
	private String firstname;
	private String lastname;
	private String password;
	private String address;
	private String status;
	
	private long otp;
	private long mobilenumber;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUser_id(int userid) {
		this.userid = userid;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getOtp() {
		return otp;
	}
	public void setOtp(long otp) {
		this.otp = otp;
	}
	
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
