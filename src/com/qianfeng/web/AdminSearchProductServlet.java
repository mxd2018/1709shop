package com.qianfeng.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qianfeng.domain.Category;
import com.qianfeng.domain.Product;
import com.qianfeng.domain.ValueBean;
import com.qianfeng.domain.vo.PageBean;
import com.qianfeng.service.ProductListService;

public class AdminSearchProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//String pname = request.getParameter("pname");
		
		//System.out.println(pname);
		Map<String, String[]> map = request.getParameterMap();
		
		ValueBean value= new ValueBean();
		try {
			BeanUtils.populate(value, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		ProductListService service = new ProductListService();
		List<Product> pList=null;
		try {
			pList = service.searchProduct(value);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ProductListService service2 = new ProductListService();
		List<Category> cList =null;
		try {
			cList = service2.showCategoryProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageBean<Product> pagebean =new PageBean<>();
		pagebean.setPageData(pList);
		int totalPage = (int) Math.ceil(pList.size()/(12*1.0));
		pagebean.setTotalPage(totalPage);
		
		request.setAttribute("pagebean", pagebean);
		
		request.setAttribute("pList", pList);
		//System.out.println(pList);
		request.setAttribute("cList", cList);
		request.setAttribute("value", value);
		
		request.getRequestDispatcher("/admin/showProduct.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}