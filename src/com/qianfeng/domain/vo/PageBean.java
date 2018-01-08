package com.qianfeng.domain.vo;

import java.util.List;

public class PageBean<T> {
	private int currentPage;
	private int currentPageCount;
	private int totalCount;
	private int totalPage;
	private List<T> pageData;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentPageCount() {
		return currentPageCount;
	}
	public void setCurrentPageCount(int currentPageCount) {
		this.currentPageCount = currentPageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", currentPageCount=" + currentPageCount + ", totalCount="
				+ totalCount + ", totalPage=" + totalPage + ", pageData=" + pageData + "]";
	}
	
	
	
}
