package com.mycode.ssh.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.mycode.ssh.entity.LinkMan;

public class LinkManDao extends HibernateDaoSupport {

	public void add(LinkMan linkMan) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(linkMan);
	}

	// 根据id查询
	public LinkMan findOne(int lkmId) {
		return this.getHibernateTemplate().get(LinkMan.class, lkmId);
	}

	@SuppressWarnings("unchecked")
	public List<LinkMan> findAll() {
		String hql = "from LinkMan";
		return (List<LinkMan>) this.getHibernateTemplate().find(hql);
	}

	// 模糊查询
	@SuppressWarnings("unchecked")
	public List<LinkMan> findDim(LinkMan linkMan) {
		/* SELECT * FROM t_linkman WHERE lkmname LIKE '%屌丝%' */
		// 方式一(不全)
		/*
		 * String hql="from LinkMan where lkmName  like ?"; return
		 * (List<LinkMan>) this.getHibernateTemplate().find(hql,
		 * "%"+linkMan.getLkmName()+"%");
		 */
		// 方式二:
		String hql = "from LinkMan where 3=3";
		List<Object> list = new ArrayList<>();
		if (linkMan.getLkmName() != null && !"".equals(linkMan.getLkmName())) {
			hql += " and lkmName like ?";
			list.add("%" + linkMan.getLkmName() + "%");
		}
		return (List<LinkMan>) this.getHibernateTemplate().find(hql, list.toArray());

	}

	public void update(LinkMan linkMan) {
		/* UPDATE t_linkman SET lkmName='外星人', lkmGerder='女' WHERE clid=1; */
		/*
		 * private String lkmName; private String lkmGerder; private String
		 * lkmPhone; private String lkmMobile;
		 */
		    LinkMan link = findOne(linkMan.getLkmId());
		String hql = "update LinkMan set lkmName=?,lkmGerder=?,lkmPhone=? lkmMobile=? where linkman.customer.cid=?";
		this.getHibernateTemplate().update(hql, link);
	}

}
