package com.mycode.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.mycode.ssh.entity.LinkMan;
import com.mycode.ssh.entity.Visit;

public class VisitDao extends HibernateDaoSupport {

	public void addVisit(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}

	@SuppressWarnings("unchecked")
	public List<Visit> findAll(Visit visit) {
		String hql = "from Visit";
		return (List<Visit>) this.getHibernateTemplate().find(hql);

	}
	@SuppressWarnings("unchecked")
	public List<Visit> findDim(Visit visit){
		/*  SELECT * FROM t_linkman WHERE lkmname LIKE '%屌丝%' */
		  
		   String hql ="from Visit where 3=3";
		  List<Object> list = new ArrayList<>();
		   if(visit.getVisitAddress()!=null&& !"".equals(visit.getVisitAddress())){
			   hql+="and visitAddress like?";
			   list.add("%"+visit.getVisitAddress()+"%");
		   }
		  return (List<Visit>) this.getHibernateTemplate().find(hql, list.toArray());
		
	 }
}
