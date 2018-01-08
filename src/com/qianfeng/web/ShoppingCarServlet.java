package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qianfeng.domain.Product;
import com.qianfeng.service.ShoppingCarService;
import com.qianfeng.utils.C3P0Utils;

public class ShoppingCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Product> pList =new ArrayList<>();
		//取出存放在session中的pid
		/*Enumeration<String> names = session.getAttributeNames();
		
		while(names.hasMoreElements()){
			
			String pid =names.nextElement();
			if(!"user".equals(pid)&&!"word".equals(pid)&&!"order".equals(pid)){
				ShoppingCarService service = new ShoppingCarService();
				try {
					Product p=service.showShoppingCarProduct(pid);
					pList.add(p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		
		//取出字符串拼接的pid
		String pid2 = (String) session.getAttribute("p");
		if(pid2!=null){
		String[] pids = pid2.split("-");
			for(String pid:pids){
				ShoppingCarService service = new ShoppingCarService();
				try {
					Product p = service.showShoppingCarProduct(pid);
					pList.add(p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//System.out.println(pList);
		
		request.setAttribute("pList", pList);
		request.getRequestDispatcher("/shoppingCarProduct.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}