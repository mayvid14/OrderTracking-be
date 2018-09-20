package com.ot.dao.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ot_merchant")
public class Merchant extends User {
	
	@OneToMany
	private List<Address> addresses;
	
	@OneToMany
	private List<Order> orders;
	
	@OneToMany
	private Set<Feed> feeds;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Set<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(Set<Feed> feeds) {
		this.feeds = feeds;
	}

	public Merchant() {
		// TODO Auto-generated constructor stub
	}
}
