package com.mycode.ssh.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.Transformers;

import com.mycode.ssh.entity.Customer;

public class CustomerDao extends BaseDao<Customer> {

	/*
	 * public void add(Customer customer) {
	 * this.getHibernateTemplate().save(customer); }
	 */

	// 查询所有的
	/*
	 * public List<Customer> findAll() { String hql = "from Customer";
	 * 
	 * @SuppressWarnings("unchecked") List<Customer> list = (List<Customer>)
	 * this.getHibernateTemplate().find(hql); return list; }
	 */

	// 根据id查询(方便修改,删去)
	/*
	 * public Customer findOne(int cid) { Customer customer =
	 * this.getHibernateTemplate().get(Customer.class, cid); return customer; }
	 */

	public List<Customer> screenFind(Customer customer) {
		/* SELECT *FROM t_customer WHERE custName LIKE '%张%' */

		String hql = "from Customer where custName like ?";

		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find(hql,
				"%" + customer.getCustName() + "%");
		return list;
	}

	/*
	 * public void delete(Customer customer) { int cid = customer.getCid();
	 * Customer c = findOne(cid); this.getHibernateTemplate().delete(c); }
	 */

	/*
	 * public void update(Customer customer) {
	 * this.getHibernateTemplate().update(customer); }
	 */

	@SuppressWarnings("unchecked")
	public int findCount() {
		String hql = "select count(*) from Customer";
		List<Object> list = (List<Object>) this.getHibernateTemplate().find(hql);
		if (list != null && list.size() != 0) {
			Object obj = list.get(0);
			// 变成int类型
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	// 分页查询
	@SuppressWarnings("unchecked")
	public List<Customer> findPage(int begin, int pageSize) {
		/*
		 * SessionFactory sessionFactory = this.getSessionFactory(); Session
		 * session = sessionFactory.getCurrentSession(); String hql =
		 * "from Customer";
		 * 
		 * // Criteria 查询
		 * 
		 * Criteria criteria = session.createCriteria("from Customer");
		 * criteria.setFirstResult(begin); criteria.setMaxResults(pageSize);
		 * List<Customer> list = criteria.list();
		 * 
		 * // query 查询 Query query = session.createQuery(hql);
		 * query.setFirstResult(begin); query.setMaxResults(pageSize);
		 * List<Customer> list = query.list();
		 */

		// 离线查询
		DetachedCriteria datachedCriteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(datachedCriteria, begin,
				pageSize);

		return list;
	}

	// 综合查询
	@SuppressWarnings("unchecked")
	public List<Customer> findMoreCondition(Customer customer) {
		/*
		 * private String custName; private String custLevel; private String
		 * custSource;
		 */
		String hql = "from Customer where 1=1";
		List<Object> listParam = new ArrayList<>();
		// custName
		if (customer.getCustName() != null && !"".equals(customer.getCustName())) {
			hql += " and custName = ?";
			listParam.add(customer.getCustName());
		}
		if (customer.getCustLevel() != null && !"".equals(customer.getCustLevel())) {
			hql += " and custLevel =?";
			listParam.add(customer.getCustLevel());
		}
		if (customer.getCustSource() != null && !"".equals(customer.getCustSource())) {
			hql += " and custSource =?";
			listParam.add(customer.getCustSource());
		}
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find(hql, listParam.toArray());

		return list;

	}

	// 根据级别分组查询
	public List findCountLevel() {
		String sql = "SELECT custLevel  , COUNT(*) as num   FROM t_customer GROUP BY custLevel";
		Session session = this.getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);

		// sqlQuery.addEntity(Customer.class);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sqlQuery.list();
		return list;
	}

	public List source() {
		String sql = "SELECT custSource, COUNT(*) AS num FROM t_customer GROUP BY custSource ";
		Session session = this.getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);

		// sqlQuery.addEntity(Customer.class);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sqlQuery.list();
		return list;

	}
}
