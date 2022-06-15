package com.citiustech.entity.embeddable;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "Customer2")
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String email;

	@ElementCollection
	@CollectionTable(name = "Customer2_Hobbies",
					 joinColumns = @JoinColumn(name = "cust_id"))
	private List<String> hobbies;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "city", column = @Column(name = "billing_city")),
		@AttributeOverride(name = "state", column = @Column(name = "billing_state")),
		@AttributeOverride(name = "pincode", column = @Column(name = "billing_pincode"))
	})
	private Address billingAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "city", column = @Column(name = "shipping_city")),
		@AttributeOverride(name = "state", column = @Column(name = "shipping_state")),
		@AttributeOverride(name = "pincode", column = @Column(name = "shipping_pincode"))
	})
	private Address shippingAddress;

	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
}
