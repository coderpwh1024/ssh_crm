package com.mycode.ssh.action;

import com.mycode.ssh.entity.User;
import com.mycode.ssh.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String username;
	private String password;

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

	public String login() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		User userExit = userService.login(user);
		if (userExit != null) {
			return "login_success";
		} else {
			return "login";
		}
	}

}
