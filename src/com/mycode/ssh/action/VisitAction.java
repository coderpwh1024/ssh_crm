package com.mycode.ssh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.mycode.ssh.entity.Customer;
import com.mycode.ssh.entity.User;
import com.mycode.ssh.entity.Visit;
import com.mycode.ssh.service.CustomerService;
import com.mycode.ssh.service.UserService;
import com.mycode.ssh.service.VisitService;
import com.opensymphony.xwork2.ModelDriven;

public class VisitAction implements ModelDriven<Visit> {

	@SuppressWarnings("unused")
	private VisitService visitService;

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	Visit visit = new Visit();

	@Override
	public Visit getModel() {
		// TODO Auto-generated method stub
		return visit;
	}

	public String addVisit() {
		visitService.addVisit(visit);
		return "addVisit";
	}

	@SuppressWarnings("unused")
	public String addPage() {
		List<User> listUser = userService.findAll();

		List<Customer> listCustomer = customerService.findAll();

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listUser", listUser);

		return "addPage";
	}

	// 列表
	public String findAll() {
		@SuppressWarnings("unused")
		List<Visit> list = visitService.findAll(visit);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}

	// 模糊查询
	public String findDim() {

		List<Visit> list = visitService.findDim(visit);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findDim";
	}

}
