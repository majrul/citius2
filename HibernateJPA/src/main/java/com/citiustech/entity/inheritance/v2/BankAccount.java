package com.citiustech.entity.inheritance.v2;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "BankAccount2")
@PrimaryKeyJoinColumn(name = "billing_id")
public class BankAccount extends BillingDetails {

	private String bankName;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
}
