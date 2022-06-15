package com.citiustech.entity.inheritance.v1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "BankAccount1")
@DiscriminatorValue("BA")
public class BankAccount extends BillingDetails {

	private String bankName;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
}
