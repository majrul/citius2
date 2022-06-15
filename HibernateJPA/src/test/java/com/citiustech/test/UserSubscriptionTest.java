package com.citiustech.test;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.Subscription;
import com.citiustech.entity.User;

public class UserSubscriptionTest {

	@Test
	public void addUser() {
		GenericDao dao = new GenericDao();
		
		User user = new User();
		user.setName("Jack");
		user.setEmail("jack@gmail.com");
		dao.save(user);
	}
	
	@Test
	public void addSubscription() {
		GenericDao dao = new GenericDao();

		Subscription s = new Subscription();
		s.setType("Science Magazine");
		s.setCost(799);
		s.setDuration(6);
		dao.save(s);
	}
	
	@Test
	public void subscribe() {
		GenericDao dao = new GenericDao();
		User user = dao.findById(User.class, 2);
		Subscription subscription = dao.findById(Subscription.class, 3);
		
		user.getSubscriptions().add(subscription);
		dao.save(user);
	}
}
