package com.citiustech.entity.manytomanyalternative;

import java.io.Serializable;
import java.util.Objects;

public class UserSubscriptionLinkPK implements Serializable {

	private User user;
	private Subscription subscription;
	
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
	@Override
	public int hashCode() {
		return Objects.hash(subscription, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSubscriptionLinkPK other = (UserSubscriptionLinkPK) obj;
		return Objects.equals(subscription, other.subscription) && Objects.equals(user, other.user);
	}
	
	
}
