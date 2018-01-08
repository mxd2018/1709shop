package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Product;
import com.qianfeng.domain.vo.PageBean;
import com.qianfeng.service.ProductListService;

public class PageProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("currentPage");
		int currentPageInt = 1;
		if(currentPage!=null&&!"".equals(currentPage)){
			 currentPageInt=Integer.parseInt(currentPage);
		}
		
		PageBean<Product> pageBean =null;
		int currentPageCount=6;
		
		ProductListService service =new ProductListService();
		try {
			pageBean=service.findProductByPageBean(currentPageInt,currentPageCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("pageBean", pageBean);
		//request.setAttribute("prolist", pageBean.getPageDate());
//		System.out.println(pageBean.getPageDate());
		request.getRequestDispatcher("/firstPage.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}