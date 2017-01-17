package com.mycode.ssh.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.mycode.ssh.dao.LinkManDao;
import com.mycode.ssh.entity.LinkMan;

@Transactional
public class LinkManService {

	private LinkManDao linkManDao;

	public LinkManDao getLinkManDao() {
		return linkManDao;
	}

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	 
	public void add(LinkMan linkMan) {
		// TODO Auto-generated method stub
		linkManDao.add(linkMan);
	}
	  public LinkMan findOne(int lkmID){
		  return linkManDao.findOne(lkmID);
	  }
	
	public List<LinkMan> findAll() {
		return linkManDao.findAll();
	}
	
	public List<LinkMan> findDim(LinkMan linkMan){
		
     return linkManDao.findDim(linkMan);
		
	}
	public void update(LinkMan linkMan){
		linkManDao.update(linkMan);
	}

	  
	 
	

}
