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

public class AdminPageProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*private int currentPage;
		private int currentPageCount;
		private int totalCount;
		private int totalPage;
		private List<T> pageData;*/
		String currentPage = request.getParameter("currentPage");
		int currentPageInt=1;
		if(currentPage!=null&&!"".equals(currentPage)){
			 currentPageInt = Integer.parseInt(currentPage);
		}
		
		int currentPageCount=12;
		
		PageBean<Product> pagebean = null;
		ProductListService service = new ProductListService();
		try {
			pagebean =service.findProductByPageBean(currentPageInt,currentPageCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/showProduct.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}