package com.mycode.ssh.entity;

public class LinkMan {

	private Integer lkmId;
	private String lkmName;
	private String lkmGerder;
	private String lkmPhone;
	private String lkmMobile;
	 
	 private Customer customer = new Customer(); 

	 
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLkmName() {
		return lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public String getLkmGerder() {
		return lkmGerder;
	}
	public void setLkmGerder(String lkmGerder) {
		this.lkmGerder = lkmGerder;
	}
	public String getLkmPhone() {
		return lkmPhone;
	}

	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}

	public String getLkmMobile() {
		return lkmMobile;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}
	public Integer getLkmId() {
		return lkmId;
	}
	public void setLkmId(Integer lkmId) {
		this.lkmId = lkmId;
	}

}
