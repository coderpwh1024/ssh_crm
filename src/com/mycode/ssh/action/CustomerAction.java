package com.mycode.ssh.action;

import java.util.List;
import org.apache.struts2.ServletActionContext;

import com.mycode.ssh.entity.Customer;
import com.mycode.ssh.entity.PageBean;
import com.mycode.ssh.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	/*
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Customer customer = new Customer();

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	List<Customer> list;

	public List<Customer> getList() {
		return list;
	}

	public String addCustomer() {
		customerService.add(customer);
		return "addCustomer";
	}

	// 根据级别
	public String selectLevel() {
		List list = customerService.findCountLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "selectLevel";
	}
	 public String source(){
		List list = customerService.source();
		ServletActionContext.getRequest().setAttribute("list", list);
		 return "source";
	 }
	

	public String deleteCus() {

		int cid = customer.getCid();
		customerService.findOne(cid);
		customerService.delete(customer);

		return "deleteCus";

	}

	public String update() {
		customerService.update(customer);
		return "update";
	}

	// 添加页面
	public String addPage() {
		return "addPage";
	}

	// 修改页面
	public String showCus() {
		int cid = customer.getCid();
		Customer cus = customerService.findOne(cid);
		ServletActionContext.getRequest().setAttribute("customer", cus);
		return "showCus";

	}

	public String list() {
		list = customerService.findAll();
		return "list";

	}

	// 综合查询-- 客户查询页面添加
	public String select() {
		return "select";
	}

	public String All() {
		List<Customer> listAll = customerService.findMoreCondition(customer);
		ServletActionContext.getRequest().setAttribute("listAll", listAll);
		return "All";
	}

	// 模糊查询
	public String screenFind() {
		list = customerService.screenFind(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "screenFind";
	}

	private Integer currentPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	// 分页
	public String listPage() {
		PageBean pageBean = customerService.findPage(currentPage);

		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listpage";
	}

}
