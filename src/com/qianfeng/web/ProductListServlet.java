package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.dao.ProductListDao;
import com.qianfeng.domain.Category;
import com.qianfeng.domain.Product;
import com.qianfeng.service.ProductListService;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductListService p=new ProductListService();
		List<Product> pList=null;
		try {
			pList=p.findAllProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*ProductListService p2=new ProductListService();
		List<Category> cList =null;
		try {
			cList = p2.showCategoryProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		request.setAttribute("pList", pList);
		/*request.setAttribute("cList", cList);*/
		request.getRequestDispatcher("/firstPage.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public Product findProduct(String pid) throws SQLException {
		ProductListDao dao=new ProductListDao();
		Product p=dao.findProduct("pid");
		return p;
	}
}