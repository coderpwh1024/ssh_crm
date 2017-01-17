package com.mycode.ssh.entity;

import java.util.List;

public class PageBean {
	/*
	 * 分页： 每页数量： pageSize 当前页: currentPage 总页数: totalPage 总记录数：totalCount
	 * 起始位置：begin
	 * 
	 */

	private Integer pageSize;
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	private Integer currentPage;

	private Integer totalPage;
	private Integer totalCount;
	private Integer begin;

	private List<Customer> list;

}
