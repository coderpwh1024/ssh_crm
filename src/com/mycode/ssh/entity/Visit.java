package com.mycode.ssh.entity;

public class Visit {
	private Integer visitId;
	private String visitAddress;
	private String visitConent;

	private Customer customer;
	private User user;
	
	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public String getVisitAddress() {
		return visitAddress;
	}

	public void setVisitAddress(String visitAddress) {
		this.visitAddress = visitAddress;
	}

	public String getVisitConent() {
		return visitConent;
	}

	public void setVisitConent(String visitConent) {
		this.visitConent = visitConent;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
