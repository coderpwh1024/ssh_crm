package com.mycode.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mycode.ssh.dao.CustomerDao;
import com.mycode.ssh.entity.Customer;
import com.mycode.ssh.entity.PageBean;

@Transactional
public class CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void add(Customer customer) {
		customerDao.add(customer);
	}

	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	// cid 查询
	public Customer findOne(int cid) {
		return customerDao.findOne(cid);
	}

	public List<Customer> screenFind(Customer customer) {

		return customerDao.screenFind(customer);

	}

	public List<Customer> findMoreCondition(Customer customer) {
		return customerDao.findMoreCondition(customer);

	}

	public List<Customer> findAll() {

		return customerDao.findAll();
	}

	/*
	 * 每页数量： pageSize 当前页: currentPage 总页数: totalPage 总记录数：totalCount 起始位置：begin
	 */

	public PageBean findPage(Integer currentPage) {

		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		// 页面数量封装
		int pageSize = 3;
		pageBean.setPageSize(pageSize);

		// 记录数封装
		Integer totalCount = customerDao.findCount();
		pageBean.setTotalCount(totalCount);

		Integer totalPage;
		// 总页数封装
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);

		Integer begin = (currentPage - 1) * pageSize;

		List<Customer> list = customerDao.findPage(begin, pageSize);
		pageBean.setList(list);

		return pageBean;

	}

	public List findCountLevel() {
		// TODO Auto-generated method stub
		return customerDao.findCountLevel();
	}

	public List source() {
		return customerDao.source();
	}

}
