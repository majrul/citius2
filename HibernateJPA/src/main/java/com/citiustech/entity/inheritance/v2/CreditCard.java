package com.citiustech.entity.inheritance.v2;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "CreditCard2")
@PrimaryKeyJoinColumn(name = "billing_id")
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
