package com.ot.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ot_task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private Integer id;
	
	@ManyToOne
	private Address pickUp;
	
	@ManyToOne
	private Address dropOff;
	
	@ManyToOne
	private Logistician assigned;
	
	@OneToOne
	private Entry entry;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "started")
	private Date started;
	
	@Column(name = "finished")
	private Date finished;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getPickUp() {
		return pickUp;
	}

	public void setPickUp(Address pickUp) {
		this.pickUp = pickUp;
	}

	public Address getDropOff() {
		return dropOff;
	}

	public void setDropOff(Address dropOff) {
		this.dropOff = dropOff;
	}

	public Logistician getAssigned() {
		return assigned;
	}

	public void setAssigned(Logistician assigned) {
		this.assigned = assigned;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public Date getFinished() {
		return finished;
	}

	public void setFinished(Date finished) {
		this.finished = finished;
	}
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
}
