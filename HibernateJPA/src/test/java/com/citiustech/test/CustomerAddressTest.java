package com.citiustech.test;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.CustomerAddressDao;
import com.citiustech.dao.GenericDao;
import com.citiustech.entity.Address;
import com.citiustech.entity.Customer;

public class CustomerAddressTest {

	@Test
	public void addCustomer() {
		Customer c = new Customer();
		c.setName("John");
		c.setEmail("john@gmail.com");
		c.setDateOfBirth(LocalDate.of(1990, 12, 31));
		
		GenericDao dao = new GenericDao();
		dao.save(c);
	}
	
	@Test
	public void addAddress() {
		Address a = new Address();
		a.setCity("Mumbai");
		a.setPincode(400001);
		a.setState("Maharashtra");
		
		GenericDao dao = new GenericDao();
		dao.save(a);
	}
	
	@Test
	public void linkAddressWithCustomer() {
		GenericDao dao = new GenericDao();
		
		Customer c = dao.findById(Customer.class, 2);
		Address a = dao.findById(Address.class, 1);
		
		c.setAddress(a);
		dao.save(c);
	}
	
	@Test
	public void addCustomerAlongWithAddress() {
		Customer c = new Customer();
		c.setName("Jack");
		c.setEmail("jack@gmail.com");
		c.setDateOfBirth(LocalDate.of(2000, 12, 31));
		
		Address a = new Address();
		a.setCity("Mumbai");
		a.setPincode(400002);
		a.setState("Maharashtra");
		
		c.setAddress(a);
		
		GenericDao dao = new GenericDao();
		dao.save(c);
	}
	
	@Test
	public void fetchAllCustomers() {
		CustomerAddressDao dao = new CustomerAddressDao();
		List<Customer> list = dao.findAllCustomers();
		//list.forEach(c -> System.out.println(c.getId() + " " + c.getName() + " " + c.getEmail() + " " + c.getDateOfBirth()));
		list.forEach(System.out::println);
	}

	@Test
	public void fetchAllCustomersByAge() {
		CustomerAddressDao dao = new CustomerAddressDao();
		List<Customer> list = dao.findAllCustomersByAge(25);
		//list.forEach(c -> System.out.println(c.getId() + " " + c.getName() + " " + c.getEmail() + " " + c.getDateOfBirth()));
		list.forEach(System.out::println);
	}

	@Test
	public void fetchAllCustomersByCity() {
		CustomerAddressDao dao = new CustomerAddressDao();
		List<Customer> list = dao.findAllCustomersByCity("Mumbai");
		//list.forEach(c -> System.out.println(c.getId() + " " + c.getName() + " " + c.getEmail() + " " + c.getDateOfBirth()));
		//list.forEach(System.out::println);
		for(Customer c : list) {
			System.out.println(c.getId() + " " + c.getName() + " " + c.getEmail() + " " + c.getDateOfBirth());
			Address a = c.getAddress();
			System.out.println(a.getCity() + " " + a.getPincode()  + " " + a.getState());
		}
	}
}
