package com.mycode.ssh.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private Integer cid;
	private String custName;
	private String custLevel;
	private String custSource;
	private String custLinkman;
	private String custPhone;
	private String custMobile;

	private Set<LinkMan> setlinkMan = new HashSet<LinkMan>();
	
	private Set<Visit> setCusVisit = new HashSet<>();

	public Set<Visit> getSetCusVisit() {
		return setCusVisit;
	}

	public void setSetCusVisit(Set<Visit> setCusVisit) {
		this.setCusVisit = setCusVisit;
	}

	public Set<LinkMan> getSetlinkMan() {
		return setlinkMan;
	}

	public void setSetlinkMan(Set<LinkMan> setlinkMan) {
		this.setlinkMan = setlinkMan;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustLinkman() {
		return custLinkman;
	}

	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

}
