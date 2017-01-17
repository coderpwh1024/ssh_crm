package com.mycode.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mycode.ssh.dao.UserDao;
import com.mycode.ssh.entity.User;
@Transactional
public class UserService {

	  public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	private UserDao userDao;

	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
}
