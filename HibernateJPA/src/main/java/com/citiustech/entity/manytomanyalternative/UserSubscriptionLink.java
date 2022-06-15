package com.citiustech.entity.manytomanyalternative;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "UserSubLinkEx2")
@Table(name = "tbl_user_subscription_link_2")
public class UserSubscriptionLink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "subs_id")
	private Subscription subscription;
	
	private LocalDate subscriptionDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public LocalDate getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(LocalDate subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
}
