package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Product;
import com.qianfeng.domain.vo.PageBean;
import com.qianfeng.service.ProductListService;

public class PageSearchProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("currentPage");
		int currentPageInt=1;
		if(currentPage!=null&&!"".equals(currentPage)){
			 currentPageInt = Integer.parseInt(currentPage);
		}
		
		int currentPageCount=12;
		
		PageBean<Product> pagebean = null;
		
		List<Product> pList = (List<Product>) request.getAttribute("pList");
		ProductListService service = new ProductListService();
		pagebean=service.pageSeacherProduct(pList,currentPageInt,currentPageCount);
		
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/showSearchProduct.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}