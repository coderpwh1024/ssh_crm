package com.mycode.ssh.dao;

import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;
/*import org.springframework.orm.hibernate5.HibernateTemplate;*/
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.mycode.ssh.entity.User;

public class UserDao extends HibernateDaoSupport {

	/*
	 * private HibernateTemplate hibernateTemplate;
	 * 
	 * public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	 * this.hibernateTemplate = hibernateTemplate; }
	 */

	@SuppressWarnings("unchecked")
	public User login(User user) {
		// TODO Auto-generated method stub
		String sql = "from User where username=? and password=?";
		 
		List<User> list = (List<User>) this.getHibernateTemplate().find(sql, user.getUsername(), user.getPassword());
		if (list != null && list.size() != 0) {
			User u = list.get(0);
			System.out.println(list.get(0).getUsername());
			return u;
		}
			return null;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String hql="from User";
		return (List<User>) this.getHibernateTemplate().find(hql);
	} 
	

}
