package com.mycode.ssh.entity;

import java.util.HashSet;
import java.util.Set;

public class User {

	 private Integer uid;
	 private String username;
	 private String password;
	 private String address;
	 
	private Set<Visit> setUserVisit = new HashSet<>();
	
	public Set<Visit> getSetUserVisit() {
		return setUserVisit;
	}
	public void setSetUserVisit(Set<Visit> setUserVisit) {
		this.setUserVisit = setUserVisit;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	 
}
