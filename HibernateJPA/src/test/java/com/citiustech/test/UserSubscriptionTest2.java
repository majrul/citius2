package com.citiustech.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.manytomanyalternative.Subscription;
import com.citiustech.entity.manytomanyalternative.User;
import com.citiustech.entity.manytomanyalternative.UserSubscriptionLink;
import com.citiustech.entity.manytomanyalternative.UserSubscriptionLinkV2;

public class UserSubscriptionTest2 {

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
		s.setType("Movie Rental");
		s.setCost(1500);
		s.setDuration(12);
		dao.save(s);
	}
	
	@Test
	public void subscribe() {
		GenericDao dao = new GenericDao();
		User user = dao.findById(User.class, 1);
		Subscription subscription = dao.findById(Subscription.class, 2);
		
		UserSubscriptionLinkV2 link = new UserSubscriptionLinkV2();
		link.setUser(user);
		link.setSubscription(subscription);
		link.setSubscriptionDate(LocalDate.now());
		dao.save(link);
	}
}
