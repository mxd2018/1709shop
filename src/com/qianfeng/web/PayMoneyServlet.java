package com.qianfeng.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.service.PayMoneyService;

public class PayMoneyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] pids = request.getParameterValues("checkSingleBox");
		
		for(String pid:pids){
			PayMoneyService service = new PayMoneyService();
			service.payMoney(pid);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}