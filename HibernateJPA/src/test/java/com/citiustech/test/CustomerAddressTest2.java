package com.citiustech.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.embeddable.Address;
import com.citiustech.entity.embeddable.Customer;


public class CustomerAddressTest2 {

	@Test
	public void add() {
		Customer c = new Customer();
		c.setName("Smith");
		c.setEmail("smith@gmail.com");
		
		Address a1 = new Address();
		a1.setCity("Mumbai");
		a1.setPincode(400002);
		a1.setState("MH");
		
		Address a2 = new Address();
		a2.setCity("Pune");
		a2.setPincode(411002);
		a2.setState("MH");
		
		c.setBillingAddress(a1);
		c.setShippingAddress(a2);

		List<String> hobbies = new ArrayList<>();
		hobbies.add("Singing");
		hobbies.add("Cooking");
		c.setHobbies(hobbies);
		
		GenericDao dao = new GenericDao();
		dao.save(c);
	}
	
}
