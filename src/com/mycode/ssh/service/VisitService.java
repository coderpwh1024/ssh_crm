package com.mycode.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.mycode.ssh.dao.VisitDao;
import com.mycode.ssh.entity.Visit;

@Transactional
public class VisitService {
 
	private VisitDao visitDao;

	public VisitDao getVisitDao() {
		return visitDao;
	}

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}
	
	 public void addVisit(Visit visit){
		  visitDao.addVisit(visit);
	 }
	 public List<Visit> findAll(Visit visit){
		 
		 return visitDao.findAll(visit);
	 }
	 public List<Visit> findDim(Visit visit){
		 return visitDao.findDim(visit);
	 }
	
}
