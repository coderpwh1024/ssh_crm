package com.mycode.ssh.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
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

	public String source() {
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

	// json 格式
	public String getListJson() throws Exception {
		List<Customer> list = customerService.findAll();
		// list---> json
		/*
		 * String jsonlist = JSON.toJSONString(list);
		 * System.out.println(jsonlist);
		 */
		// 最终格式: "totoal" :20,"rows" :[{},{}]
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", list.size());
		map.put("rows", list);
		String jsonmap = JSON.toJSONString(map);
		System.out.println(jsonmap);

		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(jsonmap);
		return NONE;
	}

	private int page;
	private int rows;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	// json 格式分页
	public String getFindAllpageJson() throws Exception {
		int begin = (page - 1) * rows;
		List<Customer> list = customerService.findAllpageCustomer(begin, rows);
		int total = customerService.findCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		String json = JSON.toJSONString(map);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		return NONE;
	}
   // 添加客户
	public String addCustomerJson() throws IOException {
		customerService.add(customer);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		String json = JSON.toJSONString(map);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		return NONE;
	}

}
