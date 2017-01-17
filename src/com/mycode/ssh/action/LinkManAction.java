package com.mycode.ssh.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.mycode.ssh.entity.Customer;
import com.mycode.ssh.entity.LinkMan;
import com.mycode.ssh.service.CustomerService;
import com.mycode.ssh.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	/*
	*  
	* 
	*/
	private static final long serialVersionUID = 1L;

	LinkMan linkMan = new LinkMan();
	Customer customer = new Customer();
	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}

	// add.jsp 页面添加
	public String addPage() {
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "addPage";

	}

	private File upload; // 上传文件
	private String uploadFileName; // 上传文件名

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	// 添加联系人
	public String addLinkman() {

		if (upload != null) {
			File fileServer = new File("C:\\uploadtest" + "/" + uploadFileName);
			try {
				FileUtil.copyFile(upload, fileServer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String cid = ServletActionContext.getRequest().getParameter("cid");
		Customer customer = new Customer();
		customer.setCid(Integer.parseInt(cid));
		linkMan.setCustomer(customer);

		linkManService.add(linkMan);
		return "addLinkman";

	}

	// 列表
	public String list() {
		List<LinkMan> list = linkManService.findAll();

		ServletActionContext.getRequest().setAttribute("list", list);

		return "list";

	}

	// 模糊查询
	public String findDim() {

		List<LinkMan> list = linkManService.findDim(linkMan);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findDim";
	}
      
	public String showLinkMan() {
		// 更具id查询联系
		int lkmId = linkMan.getLkmId();
		LinkMan link = linkManService.findOne(lkmId);

		List<Customer> list = customerService.findAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("linkMan", link);
		request.setAttribute("listCustomer", list);

		return "showLinkMan";
	}
	 public String submit(){
		 
	    linkManService.update(linkMan);
	    
		return "submit";
		 
	 }
	

}
