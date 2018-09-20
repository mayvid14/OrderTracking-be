package com.ot.dao.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ot_log")
public class Logistician extends User {
	
	@Column(name = "company")
	private String company;
	
	@OneToMany
	private List<Address> addresses;
	
	@OneToMany
	private Set<Task> tasks;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	public Logistician() {
		// TODO Auto-generated constructor stub
	}

}
