package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.buyProducts;
import com.qianfeng.domain.shoppingUser;
import com.qianfeng.domain.vo.Order;
import com.qianfeng.service.PayMoneyService;

public class Order_historyDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		shoppingUser user = (shoppingUser) session.getAttribute("user");
		String uid = null;
		String oid = request.getParameter("oid");
		
		if(user!=null){
			uid = user.getUid();
		}
		
		
		PayMoneyService service = new PayMoneyService();
		Order o =null;
		List<buyProducts> list =null;
		try {
			list = service.getOrder_detail(uid,oid);
			o =service.getOrder(oid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list",list);
		request.setAttribute("o", o);
		request.getRequestDispatcher("/orderHistoryDetail.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}