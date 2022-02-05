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
	
	
	public int getAddressid() {
		return addressid;
	}


	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}


	public int getDoorno() {
		return doorno;
	}


	public void setDoorno(int doorno) {
		this.doorno = doorno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStreetname() {
		return streetname;
	}


	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public long getPincode() {
		return pincode;
	}


	public void setPincode(long pincode) {
		this.pincode = pincode;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	public long getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}


	public EcommerceUser getUserdata() {
		return userdata;
	}


	public void setUserdata(EcommerceUser userdata) {
		this.userdata = userdata;
	}



}
