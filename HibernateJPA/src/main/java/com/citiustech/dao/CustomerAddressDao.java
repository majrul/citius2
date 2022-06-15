package com.citiustech.dao;

import java.sql.Date;
import java.util.List;

import com.citiustech.entity.Customer;

public class CustomerAddressDao extends GenericDao {

	public List<Customer> findAllCustomers() {
		return entityManagerFactory
				.createEntityManager()
				.createQuery("select c from Customer c") //JPQL
				.getResultList();
	}
	
	public List<Customer> findAllCustomersByAge(int age) {
		return entityManagerFactory
				.createEntityManager()
				.createQuery("select c from Customer c where year(current_date()) - year(c.dateOfBirth) >= :age")
				.setParameter("age", age)
				.getResultList();
	}
	
	public List<Customer> findAllCustomersByCity(String city) {
		return entityManagerFactory
				.createEntityManager()
				.createQuery("select c from Customer c inner join c.address a where a.city = :ct", Customer.class)
				.setParameter("ct", city)
				.getResultList();
	}
}
