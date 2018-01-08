package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.User;
import com.qianfeng.domain.shoppingUser;
import com.qianfeng.domain.vo.Order;
import com.qianfeng.service.OrderHistoryService;

public class OrderHistoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderHistoryService service= new OrderHistoryService();
		List<Order> orderhistory =null;
		HttpSession session = request.getSession();
		shoppingUser user = (shoppingUser) session.getAttribute("user");
		String uid=null;
		if(user!=null){
			uid=user.getUid();
		}
		try {
			orderhistory = service.findOrders(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("orderhistory", orderhistory);
		request.getRequestDispatcher("/orderHistory.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}