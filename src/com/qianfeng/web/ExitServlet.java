package com.qianfeng.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		//
		Cookie cookie_uname=new Cookie("cookie_uname", "");
		cookie_uname.setMaxAge(0);
		Cookie cookie_password=new Cookie("cookie_password", "");
		cookie_password.setMaxAge(0);
		response.addCookie(cookie_password);
		response.addCookie(cookie_uname);
		
		response.sendRedirect(request.getContextPath()+"/pageProductServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}