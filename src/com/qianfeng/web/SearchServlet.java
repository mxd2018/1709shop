package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qianfeng.domain.Product;
import com.qianfeng.service.SearchService;

import sun.net.www.content.text.plain;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String info = request.getParameter("info");
		SearchService service=new SearchService();
		List<Product> list=null;
		
		try {
			list=service.findProductListBySearch(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(list);
		Gson gson= new Gson();
		String json = gson.toJson(list);
		
		//System.out.println(json);
		if(json!=null){
			response.getWriter().write(json);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}