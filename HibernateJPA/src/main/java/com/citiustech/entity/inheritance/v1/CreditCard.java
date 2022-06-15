package com.citiustech.entity.inheritance.v1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "CreditCard1")
@DiscriminatorValue("CC")
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
