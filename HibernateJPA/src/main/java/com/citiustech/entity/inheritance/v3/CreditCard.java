package com.citiustech.entity.inheritance.v3;

import javax.persistence.Entity;

@Entity(name = "CreditCard3")
public class CreditCard extends BillingDetails {

	private String type;
	private String expiry;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	
	
}
