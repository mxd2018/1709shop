package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Category;
import com.qianfeng.domain.Product;
import com.qianfeng.service.ProductListService;

public class ShowEditProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		ProductListService service = new ProductListService();
		Product pro =null;
		try {
			pro = service.editProduct(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProductListService service2 = new ProductListService();
		List<Category> cList =null;
		try {
			cList = service2.showCategoryProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("pro", pro);
		request.setAttribute("cList",cList);
		request.getRequestDispatcher("admin/editProduct.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}